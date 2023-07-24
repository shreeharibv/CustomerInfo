package com.ivoyant.customerInfo.repository;
import org.springframework.data.repository.CrudRepository;
import com.ivoyant.customerInfo.entity.Logger;
public interface LoggerRepository extends CrudRepository<Logger, Integer>{
}
