package springDataQueriesExercises.notEntity;

import springDataQueriesExercises.entities.AgeRestriction;
import springDataQueriesExercises.entities.EditionType;

import java.math.BigDecimal;


public interface ReducedBook {

     String getTitle();
     EditionType getEditionType();
     AgeRestriction getAgeRestriction();
     BigDecimal getPrice();

}
