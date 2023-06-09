package com.example.redis.repositoty;

import com.example.redis.entity.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeRepository {
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public EmployeeRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveEmployee(Employee employee){
        hashOperations.put("EMPLOYEE", employee.getId(),employee);
    }

    public List<Employee> fillAll(){
        return hashOperations.values("EMPLOYEE");
    }

    public Employee findById(Integer id){
        return (Employee) hashOperations.get("EMPLOYEE", id);
    }

    public void update(Employee employee){
        saveEmployee(employee);
    }

    public void delete(Integer id){
        hashOperations.delete("EMPLOYEE", id);
    }

}
