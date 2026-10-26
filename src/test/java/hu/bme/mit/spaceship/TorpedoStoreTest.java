package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void illegalFire1(){
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
    }

    @Test
    void illegalFire2(){
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void torpedoCountAfterFire(){
        TorpedoStore store = new TorpedoStore(2);
        store.fire(1);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void hasTorpedos(){
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(false, store.isEmpty());
    }

    @Test
    void doesntHaveTorpedos(){
        TorpedoStore store = new TorpedoStore(0);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void alwaysFails(){
        TorpedoStore store = new TorpedoStore(1, 1);
        assertEquals(false, store.fire(1));
    }

}
