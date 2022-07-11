package com.mapproject.resources.events;

import java.util.List;

public class PacificEncounter extends Event {

    private String description;
    private String itemGivenResponse;
    private String itemNotGivenResponse;
    private List<Integer> requestedItemId; // if the encounter doesnt require an item, it will be -1
                                           // if any item can be given, it will be -2
    private List<Integer> giftedItemId;

    public PacificEncounter(int eventId, String name, String presentation, boolean isSkippable,
            String description, String itemGivenResponse, String itemNotGivenResponse,
            List<Integer> requestedItemId, List<Integer> giftedItemId) {
        super(eventId, name, presentation, isSkippable);
        this.description = description;
        this.requestedItemId = requestedItemId;
        this.giftedItemId = giftedItemId;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemGivenResponse() {
        return itemGivenResponse;
    }

    public void setItemGivenResponse(String itemGivenResponse) {
        this.itemGivenResponse = itemGivenResponse;
    }

    public String getItemNotGivenResponse() {
        return itemNotGivenResponse;
    }

    public void setItemNotGivenResponse(String itemNotGivenResponse) {
        this.itemNotGivenResponse = itemNotGivenResponse;
    }

    public List<Integer> getRequestedItemId() {
        return requestedItemId;
    }

    public List<Integer> getGiftedItemId() {
        return giftedItemId;
    }

    public void setRequestedItemId(List<Integer> requestedItemId) {
        this.requestedItemId = requestedItemId;
    }

    public void setGiftedItemId(List<Integer> giftedItemId) {
        this.giftedItemId = giftedItemId;
    }

}
