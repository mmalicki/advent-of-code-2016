package day10.model;

public enum ReceivingLevel {
    LOWER {
        @Override
        public int removeChipFrom(Bot donorBot) {
            return donorBot.removeLowerValueChip();
        }
    }, HIGHER {
        @Override
        public int removeChipFrom(Bot donorBot) {
            return donorBot.removeHigherValueChip();
        }
    };

    public abstract int removeChipFrom(Bot donorBot);
}
