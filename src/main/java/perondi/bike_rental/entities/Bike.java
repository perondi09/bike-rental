package perondi.bike_rental.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "bikes")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Bike {

    @MongoId
    private Long identifier;

    private String model;

    private String year;

    @Indexed(name="plate")
    private String plate;
}
