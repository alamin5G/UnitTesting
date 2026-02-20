public class ParkingLot {
    private final int totalSpots;
    private int occupiedSpots;

    public ParkingLot(int totalSpots){
        if (totalSpots <= 0) {
            throw new IllegalArgumentException("Total spots must be greater than zero.");
        }

        this.totalSpots = totalSpots;
        this.occupiedSpots = 0;
    }

    public void parkVehicle() {
        if (occupiedSpots > totalSpots) {
            throw new IllegalStateException("Parking lot is full. No available spots.");
        }
        occupiedSpots++;
    }

    public  void unparkVehicle() {
        if (occupiedSpots <= 0) {
            throw new IllegalStateException("Parking lot is already empty. No vehicles to unpark.");
        }
        occupiedSpots--;
    }

    public int getAvailableSpots() {
        return totalSpots - occupiedSpots;
    }

    public int getOccupiedSpots() {
        return occupiedSpots;
    }

    public int getTotalSpots() {
        return totalSpots;
    }
}
