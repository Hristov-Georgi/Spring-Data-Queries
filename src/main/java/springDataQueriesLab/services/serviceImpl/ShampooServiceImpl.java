package springDataQueriesLab.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDataQueriesLab.entities.Shampoo;
import springDataQueriesLab.entities.Size;
import springDataQueriesLab.repositories.ShampooRepository;
import springDataQueriesLab.services.ShampooService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    protected ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> selectAllShampoosBySize(String size) {

        Size shampooSize = Size.valueOf(size);

        return shampooRepository.findAllBySize(shampooSize);
    }

    @Override
    public List<Shampoo> selectBySizeAndLabelId(String size, Long id) {
        Size shampooSize = Size.valueOf(size);

        return shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(shampooSize, id);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveByPrice(Double price) {
        BigDecimal inputPrice = BigDecimal.valueOf(price);

        return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(inputPrice);
    }
}
