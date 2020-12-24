package ru.sonicxd2.sklad.income;

import ru.sonicxd2.sklad.product.Product;
import ru.sonicxd2.sklad.product.ProductStatus;
import ru.sonicxd2.sklad.utilization.Kamaz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IncomeService {
    private Kamaz kamaz = Kamaz.KAMAZ;
    private List<IncomeItem> incomeItemList = new ArrayList<>();

    public void addIncomeItems(IncomeItem incomeItem) {
        incomeItemList.add(incomeItem);
    }

    public List<Product> processItems() {
        List<Product> productList = new ArrayList<>();
        for (IncomeItem item : incomeItemList) {
            if ((item.getProductStatus() == ProductStatus.DESTRUCTED_BY_KAMAZ) || (item.getProductStatus() == ProductStatus.SPOILED)) {
                kamaz.utilize(item);
            }
            productList.add(new Product(-1, item.getProductMetadata(), item.getProductStatus(), item.getProductType(), BigDecimal.ONE, item.getExpiringDate() ,item.getDescriptionLocation()));
        }
        incomeItemList.clear();
        return productList;
    }
}
