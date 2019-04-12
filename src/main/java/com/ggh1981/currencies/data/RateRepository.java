package com.ggh1981.currencies.data;

import org.springframework.data.repository.CrudRepository;

import com.ggh1981.currencies.model.RatesUSDBased;

public interface RateRepository extends CrudRepository<RatesUSDBased, String> {

}
