package com.appdirect.assignment.services;

import com.appdirect.assignment.dto.EventDTO;
import com.appdirect.assignment.dto.EventResponseDTO;
import com.appdirect.assignment.dto.UserDTO;
import com.appdirect.assignment.enums.ErrorCode;
import com.appdirect.assignment.mapper.ViewMapper;
import com.appdirect.assignment.persist.entity.Account;
import com.appdirect.assignment.persist.entity.User;
import com.appdirect.assignment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaurav on 24/12/16.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    OAuthAuthenticationService oAuthAuthenticationService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ViewMapper viewMapper;

    public EventResponseDTO handleEvent(String eventUrl) {
        EventDTO eventDTO = oAuthAuthenticationService.validatingRequestsFromAppDirect(eventUrl);
        EventResponseDTO eventResponseDTO = null;
        if(eventDTO==null) {
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.UNKNOWN_ERROR, "Error During event creation");
        } else {
            eventResponseDTO = getEventResponseFromEvent(eventDTO);
        }
        return eventResponseDTO;
    }
    private EventResponseDTO getEventResponseFromEvent(EventDTO event) {
        EventResponseDTO eventResponse;
        switch (event.getType()){
            case SUBSCRIPTION_ORDER:
                eventResponse = handleSubscriptionCreation(event);
                break;
            case SUBSCRIPTION_CHANGE:
                eventResponse = handleSubscriptionChange(event);
                break;
            case SUBSCRIPTION_CANCEL:
                eventResponse = handleSubscriptionCancel(event);
                break;
            case USER_ASSIGNMENT:
                eventResponse = handleAssignUser(event);
                break;
            case USER_UNASSIGNMENT:
                eventResponse = handleUnassignUser(event);
                break;
            default:
                eventResponse = new EventResponseDTO(false, null, ErrorCode.UNKNOWN_ERROR,
                        "Unknown EventType");
        }
        return eventResponse;
    }

    private EventResponseDTO handleUnassignUser(EventDTO event) {
        EventResponseDTO eventResponseDTO;
        Account account = accountRepository.findOne(event.getPayload().getAccount().getAccountIdentifier());
        UserDTO userDTO = event.getPayload().getUser();
        if(account==null){
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.ACCOUNT_NOT_FOUND,
                    "Subscription account Not Found");
        } else if(!account.getUsers().contains(viewMapper.map(userDTO, User.class))) {
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.USER_NOT_FOUND,
                    "User does not belong to account");
        } else if(account.getCreator().getUuid().equals(userDTO.getUuid())){
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.UNAUTHORIZED,
                    "Admin user cannot be unassigned");
        } else {
            account.getUsers().remove(viewMapper.map(userDTO, User.class));
            accountRepository.save(account);
            eventResponseDTO = new EventResponseDTO(account.getUuid(), "Successfully unassigned user");
        }
        return eventResponseDTO;
    }

    private EventResponseDTO handleAssignUser(EventDTO event) {
        EventResponseDTO eventResponseDTO;
        UserDTO userDTO = event.getPayload().getUser();
        Account account = accountRepository.findOne(event.getPayload().getAccount().getAccountIdentifier());
        if(account==null){
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.ACCOUNT_NOT_FOUND,
                    "Subscription account Not Found");
        } else if(account.getUsers().contains(viewMapper.map(userDTO, User.class))) {
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.USER_ALREADY_EXISTS,
                    "User already assigned");
        } else {
            account.getUsers().add(viewMapper.map(userDTO, User.class));
            accountRepository.save(account);
            eventResponseDTO = new EventResponseDTO(account.getUuid(), "Successfully assigned user");
        }
        return eventResponseDTO;
    }

    private EventResponseDTO handleSubscriptionCancel(EventDTO event) {
        EventResponseDTO eventResponseDTO;
        Account account = accountRepository.findOne(event.getPayload().getAccount().getAccountIdentifier());
        if(account!=null){
            accountRepository.delete(account);
            eventResponseDTO = new EventResponseDTO(account.getUuid(),
                    "Successful subscription cancel");
        } else {
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.ACCOUNT_NOT_FOUND,
                    "Subscription account Not Found");
        }
        return eventResponseDTO;
    }

    private EventResponseDTO handleSubscriptionChange(EventDTO event) {
        EventResponseDTO eventResponseDTO;
        Account account = accountRepository.findOne(event.getPayload().getAccount().getAccountIdentifier());
        if(account==null){
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.ACCOUNT_NOT_FOUND,
                    "Subscription account Not Found");
        } else {
            account.setAccountStatus(event.getPayload().getAccount().getStatus());
            accountRepository.save(account);
            eventResponseDTO = new EventResponseDTO(account.getUuid(),
                    "Successful subscription change");
        }
        return eventResponseDTO;
    }

    private EventResponseDTO handleSubscriptionCreation(EventDTO event) {
        EventResponseDTO eventResponseDTO;
        Account account = accountRepository.findOne(event.getPayload().getCompany().getUuid());
        if(account!=null){
            eventResponseDTO = new EventResponseDTO(false, null, ErrorCode.UNKNOWN_ERROR,
                    "Subscription account already exist");
        } else {
            account = new Account();
            account.setUuid(event.getPayload().getCompany().getUuid());
            account.setAccountStatus(event.getPayload().getOrder().getEditionCode());
            User user = viewMapper.map(event.getCreator(), User.class);
            account.setCreator(user);
            List<User> users = new ArrayList<User>();
            users.add(user);
            account.setUsers(users);
            accountRepository.save(account);
            eventResponseDTO  =new EventResponseDTO(account.getUuid(),
                    "Successful subscription creation");
        }
        return eventResponseDTO;
    }

}
