package perondi.bike_rental.listeners.dto;

public record BikeRegisterEvent(
		long identifier,
		String year,
		String model,
		String plate
) {
}
