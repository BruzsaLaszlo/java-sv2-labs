package statemachine.seatheater;

public enum SeatHeaterState {

    OFF{
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.HIGH;
        }
    },

    HIGH {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.MID;
        }
    },

    MID {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.LOW;
        }
    },

    LOW {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    };

    abstract SeatHeaterState next();

}
