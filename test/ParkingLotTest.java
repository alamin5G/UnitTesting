import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Parking Lot Test Suite")
public class ParkingLotTest {

    // ==================== TESTS ====================
    // Test 1: Invalid Total Spots
    // Test 2: Valid Total Spots
    // Test 3: Park Vehicle
    // Test 4: Park Vehicle When Parking Lot is Full
    // Test 5: Unpark Vehicle
    // Test 6: Unpark Vehicle When Parking Lot is Zero or Less
    // Test 7: Get Available Spots After Parking
    // Test 8: Get Available Spots After Unparking
    // Test 9: Get Occupied Spots After Parking
    // Test 10: Get Occupied Spots After Unparking

    @Test
    @DisplayName("Test Vehicle invalid total spot: Should Throw IllegalStateException When Total Spots are less than or zero")
    public void parkVehicleWithInvalidTotalSpots() {
        // Arrange
        int invalidTotalSpots = 0;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new ParkingLot(invalidTotalSpots));

    }


    @Test
    @DisplayName("Test Vehicle valid total spot: Should not throw exception when total parking spots are greater than zero")
    public void parkVehicleWithValidTotalSpots() {
        // Arrange
        int validTotalSpot = 5;
        // Act
        ParkingLot parkingLot =  new ParkingLot(validTotalSpot);
        // Assert
        int expectedTotalSpots = validTotalSpot;
        assertEquals(expectedTotalSpots, parkingLot.getTotalSpots());
    }


    @Test
    @DisplayName("Test Park Vehicle: Should Increase Occupied Spots by 1 When Parking a Vehicle")
    public void parkVehicle() {

        // Arrange
        ParkingLot parkingLot = new ParkingLot(2);
        int initialOccupiedSpots = parkingLot.getOccupiedSpots();

        // Act
        parkingLot.parkVehicle();

        // Assert
        int expectedOccupiedSpots = initialOccupiedSpots + 1;
        assertEquals(expectedOccupiedSpots, parkingLot.getOccupiedSpots());
    }

    @Test
    @DisplayName("Test Park Vehicle Full: Should Throw IllegalStateException When Parking Lot is greater than total spots")
    public void parkVehicleWhenParkingLotIsFull() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);

        // Act
        parkingLot.parkVehicle();
        parkingLot.parkVehicle();

        // Assert
        assertThrows(IllegalStateException.class, parkingLot::parkVehicle);
    }
    
    @Test
    @DisplayName("Test Unpark Vehicle: Should Decrease Occupied Spots in Parking Lot by 1 When Unparking a Vehicle")
    public void unparkVehicle() {

        //Arrange
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkVehicle();
        parkingLot.parkVehicle();

        int initialOccupiedSpots = parkingLot.getOccupiedSpots();

        //Act
        parkingLot.unparkVehicle();
        int expectedOccupiedSpots = initialOccupiedSpots - 1;

        //Assert
        assertEquals(expectedOccupiedSpots, parkingLot.getOccupiedSpots());
    }

    @Test
    @DisplayName("Test Unpark Vehicle : Should Throw IllegalStateException When Parking Lot is zero or less")
    public void unparkVehicleWhenParkingLotIsZeroOrLess() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkVehicle();

        // Act
        parkingLot.unparkVehicle();

        // Assert
        assertThrows(IllegalStateException.class, parkingLot::unparkVehicle);

    }


    @Test
    @DisplayName("Test Get Vehicle Available Spots: Should Return Correct Number of Available Spots After Parking")
    public void getAvailableSpotsAfterParking() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.parkVehicle();
        parkingLot.parkVehicle();

        // Act
        int availableSpotsAfterParking = parkingLot.getAvailableSpots();

        // Assert
        assertEquals(1, availableSpotsAfterParking);
    }

    @Test
    @DisplayName("Test Get Vehicle Available Spot : Should Return Correct Number of available Spots After Unparking")
    public void getAvailableSpotsAfterUnparking() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.parkVehicle();
        parkingLot.parkVehicle();

        // Act
        parkingLot.unparkVehicle();
        int availableSpotAfterUnpark = parkingLot.getAvailableSpots();
        int expectedAvailableSpotAfterUnpark = 2;

        // Assert
        assertEquals(expectedAvailableSpotAfterUnpark, availableSpotAfterUnpark);
    }


    @Test
    @DisplayName("Test Get Vehicle Occupied Spots: Should Return Correct Number of Occupied Spots After Parking")
    public void getOccupiedSpotsAfterParking() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.parkVehicle();
        parkingLot.parkVehicle();

        // Act
        int occupiedSpotsAfterParking = parkingLot.getOccupiedSpots();

        // Assert
        assertEquals(2, occupiedSpotsAfterParking);
    }

    @Test
    @DisplayName("Test Get Vehicle Occupied Spots: Should Return Correct Number of Occupied Spots After Unparking")
    public void getOccupiedSpotsAfterUnparking() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.parkVehicle();
        parkingLot.parkVehicle();

        // Act
        parkingLot.unparkVehicle();
        int occupiedSpotsAfterUnpark = parkingLot.getOccupiedSpots();
        int expectedOccupiedSpotsAfterUnpark = 1;

        // Assert
        assertEquals(expectedOccupiedSpotsAfterUnpark, occupiedSpotsAfterUnpark);
    }


}
