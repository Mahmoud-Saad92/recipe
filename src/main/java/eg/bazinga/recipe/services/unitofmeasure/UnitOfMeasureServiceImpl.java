package eg.bazinga.recipe.services.unitofmeasure;

import eg.bazinga.recipe.models.UnitOfMeasure;
import eg.bazinga.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureByDescription(String description) {

        UnitOfMeasure unitOfMeasure;
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription(description);

        if (optionalUnitOfMeasure.isPresent()) {
            unitOfMeasure = optionalUnitOfMeasure.get();
        } else {
            throw new RuntimeException("Expected UOM Not Found");
        }

        return unitOfMeasure;
    }
}
