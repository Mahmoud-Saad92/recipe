package eg.bazinga.recipe.services.unitofmeasure;

import eg.bazinga.recipe.models.UnitOfMeasure;
import eg.bazinga.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureByDescription(String description) {
        log.debug("Fetching All Units Of Measure By Description...");

        UnitOfMeasure unitOfMeasure;
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription(description);

        if (optionalUnitOfMeasure.isPresent()) {
            unitOfMeasure = optionalUnitOfMeasure.get();
        } else {
            log.error("There are no units of measure by description found...");

            throw new RuntimeException("Expected UOM Not Found");
        }

        return unitOfMeasure;
    }
}
