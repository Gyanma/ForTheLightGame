package com.mapproject.resources.events;

import com.mapproject.enums.Location;
import com.mapproject.resources.items.Item;

public class JugPuzzle extends TextPuzzle {

    static class Jug {
        private int jugContent;
        private final int jugCapacity;

        public Jug(int jugContent, int jugCapacity) {
            this.jugContent = jugContent;
            this.jugCapacity = jugCapacity;
        }

        public int getJugContent() {
            return jugContent;
        }

        public int getJugCapacity() {
            return jugCapacity;
        }

        public void setJugContent(int jugContent) {
            this.jugContent = jugContent;
        }

    }

    static class JugSet {

        private Jug jug1;
        private Jug jug2;
        private Jug jug3;

        public JugSet(int jug1Content, int jug1Capacity, int jug2Content, int jug2Capacity, int jug3Content,
                int jug3Capacity) {
            this.jug1 = new Jug(jug1Content, jug1Capacity);
            this.jug2 = new Jug(jug2Content, jug2Capacity);
            this.jug3 = new Jug(jug3Content, jug3Capacity);
        }

        public Jug getJug1() {
            return jug1;
        }

        public Jug getJug2() {
            return jug2;
        }

        public Jug getJug3() {
            return jug3;
        }

        public void setJug1(Jug jug1) {
            this.jug1 = jug1;
        }

        public void setJug2(Jug jug2) {
            this.jug2 = jug2;
        }

        public void setJug3(Jug jug3) {
            this.jug3 = jug3;
        }

        public void pourJug(Jug originJug, Jug endJug) {
            if (originJug.getJugContent() + endJug.getJugContent() <= endJug.getJugCapacity()) {
                endJug.setJugContent(originJug.getJugContent() + endJug.getJugContent());
                originJug.setJugContent(0);
            } else {
                endJug.setJugContent(endJug.getJugCapacity());
                originJug.setJugContent(originJug.getJugContent() - (endJug.getJugCapacity() - endJug.getJugContent()));
            }
        }

        public boolean equals(JugSet jugSet) {
            return this.jug1.getJugContent() == jugSet.getJug1().getJugContent() &&
                    this.jug2.getJugContent() == jugSet.getJug2().getJugContent() &&
                    this.jug3.getJugContent() == jugSet.getJug3().getJugContent();
        }
    }

    private JugSet playerJugSet;
    private JugSet correctJugSet;

    public JugPuzzle(int eventId, String name, String presentation, Location location,
            String question, String answer, boolean isSingleAnswer,
            String correctReply, String incorrectReply, String tryAgainReply, String surrenderReply,
            Item reward) {
        super(eventId, name, presentation, location, question, answer,
                isSingleAnswer, correctReply, incorrectReply, tryAgainReply, surrenderReply, reward);

    }

    public JugPuzzle(int eventId, String name, String presentation, Location location,
            String question, String answer, boolean isSingleAnswer,
            String correctReply, String incorrectReply, String tryAgainReply, String surrenderReply,
            Item reward, JugSet playerJugSet, JugSet correctJugSet) {
        super(eventId, name, presentation, location, question, answer,
                isSingleAnswer, correctReply, incorrectReply, tryAgainReply, surrenderReply, reward);
        this.playerJugSet = playerJugSet;
        this.correctJugSet = correctJugSet;
    }

    public void pourJug(Jug originJug, Jug endJug) {
        playerJugSet.pourJug(originJug, endJug);
    }

    public boolean isCorrect() {
        return playerJugSet.equals(correctJugSet);
    }

}
