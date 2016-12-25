package com.appdirect.assignment.dto;

import com.appdirect.assignment.enums.EventType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by gaurav on 24/12/16.
 */
@XmlRootElement(name="event")
public class EventDTO {
    private EventType type;
    private MarketplaceDTO marketplace;
    private UserDTO creator;
    private PayloadDTO payload;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public MarketplaceDTO getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(MarketplaceDTO marketplace) {
        this.marketplace = marketplace;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public PayloadDTO getPayload() {
        return payload;
    }

    public void setPayload(PayloadDTO payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", marketplace=" + marketplace +
                ", creator=" + creator +
                ", payload=" + payload +
                '}';
    }
}

