package com.example.watchshop.bestellung;

public enum BestellungStatus {
    Bearbeitet {
        @Override
        public BestellungStatus changeState() {
            return Bezahlt;
        }


    }, Bezahlt {
        @Override
        public BestellungStatus changeState() {
            return Geliefert;
        }
    }, Geliefert {
        @Override
        public BestellungStatus changeState() {
            return Zugestellt;
        }


    }, Zugestellt {
        @Override
        public BestellungStatus changeState() {
            return this;

        }
    };
        public abstract BestellungStatus changeState();
    }
