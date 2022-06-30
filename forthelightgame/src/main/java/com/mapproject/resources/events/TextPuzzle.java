package com.mapproject.resources.events;

import com.mapproject.resources.items.Item;

public class TextPuzzle extends Event {

    private String question;

    private boolean isSingleAnswer; // true if the answer is simple, false if it's composed

    private String answer;// if the answer is composed, the aswers are separated by a "+"

    private String correctReply; // npc's response in case of correct answer

    private String incorrectReply;// npc's response in case of incorrect answer

    private String tryAgainReply; // npc's response when you are able to try again

    private String surrenderReply; // npc's response when you surrender

    private Item reward; // item reward in case of correct answer

    public TextPuzzle(int eventId, String name, String presentation, boolean skippable,
            String question, String answer, boolean isSingleAnswer,
            String correctReply, String incorrectReply, String tryAgainReply, String surrenderReply,
            Item reward) {
        super(eventId, name, presentation, skippable);
        setQuestion(question);
        setAnswer(answer);
        setSingleAnswer(isSingleAnswer);
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isSingleAnswer() {
        return isSingleAnswer;
    }

    public void setSingleAnswer(boolean isSingleAnswer) {
        this.isSingleAnswer = isSingleAnswer;
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

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }

    public String getSurrenderReply() {
        return surrenderReply;
    }

    public void setSurrenderReply(String surrenderReply) {
        this.surrenderReply = surrenderReply;
    }
}