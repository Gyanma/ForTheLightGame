package com.mapproject.resources.events;

public class TextPuzzle extends Event {

    private String question;

    private String answer;

    private String correctReply; // npc's response in case of correct answer

    private String incorrectReply;// npc's response in case of incorrect answer

    private String tryAgainReply; // npc's response when you are able to try again

    private String surrenderReply; // npc's response when you surrender

    private int rewardId; // item reward in case of correct answer

    public TextPuzzle(int eventId, String name, String presentation,
            String question, String answer, String correctReply, String incorrectReply, String tryAgainReply,
            String surrenderReply,
            int rewardId) {
        super(eventId, name, presentation, true);
        this.question = question;
        this.answer = answer;
        this.correctReply = correctReply;
        this.incorrectReply = incorrectReply;
        this.tryAgainReply = tryAgainReply;
        this.surrenderReply = surrenderReply;
        this.rewardId = rewardId;

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

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }
}