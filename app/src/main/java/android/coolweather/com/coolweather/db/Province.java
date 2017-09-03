package android.coolweather.com.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by cyp on 2017/9/3.
 */

public class Province extends DataSupport {
    private int id;
    private  String provinceName;
    private  int ProvinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return ProvinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        ProvinceCode = provinceCode;
    }
}
