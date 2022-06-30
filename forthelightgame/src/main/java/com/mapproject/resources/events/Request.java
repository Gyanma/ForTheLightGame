package com.mapproject.resources.events;

import java.util.ArrayList;
import java.util.List;

import com.mapproject.resources.items.Item;

public class Request extends Event {

    private String question;

    private List<String> answers = new ArrayList<>();

    private String correctReply; // npc's response in case of correct answer

    private String incorrectReply;// npc's response in case of incorrect answer

    private String tryAgainReply; // npc's response when you are able to try again

    private String surrenderReply; // npc's response when you surrender

    private Item reward; // item reward in case of correct answer

    public Request(int eventId) {
        super(eventId);

    }

    public Request(int eventId, String name, String description, boolean skippable) {
        super(eventId, name, description, skippable);

    }

    public Request(String name, String description, int eventId, boolean skippable,
            String question, List<String> answer, String correctReply, String incorrectReply,
            String tryAgainReply, String surrenderReply, Item reward) {
        super(eventId, name, description, skippable);
        setQuestion(question);
        setAnswer(answer);
        setCorrectReply(correctReply);
        setIncorrectReply(incorrectReply);
        setTryAgainReply(tryAgainReply);
        setSurrenderReply(surrenderReply);
        setReward(reward);

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswer() {
        return answers;
    }

    public void setAnswer(List<String> answer) {
        this.answers = answer;
    }

    public String getCorrectReply() {
        return correctReply;
    }

    public void setCorrectReply(String correctReply) {
        this.correctReply = correctReply;
    }

    public String getIncorrectReply() {
        return incorrectReply;
    }

    public void setIncorrectReply(String incorrectReply) {
        this.incorrectReply = incorrectReply;
    }

    public String getTryAgainReply() {
        return tryAgainReply;
    }

    public void setTryAgainReply(String tryAgainReply) {
        this.tryAgainReply = tryAgainReply;
    }

    public String getSurrenderReply() {
        return surrenderReply;
    }

    public void setSurrenderReply(String surrenderReply) {
        this.surrenderReply = surrenderReply;
    }

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }

}
