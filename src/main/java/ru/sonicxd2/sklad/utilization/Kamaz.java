package ru.sonicxd2.sklad.utilization;

public interface Kamaz {
    Kamaz KAMAZ = new Kamaz() {
        @Override
        public void utilize(Object object) {

        }
    };

    void utilize(Object object);
}
