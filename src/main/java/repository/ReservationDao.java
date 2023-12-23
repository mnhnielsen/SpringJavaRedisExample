package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import Model.Reservation;

@Repository
public class ReservationDao {

    
    public static final String HASH_KEY = "Reservation";
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Reservation save(Reservation reservation){
        template.opsForHash().put(HASH_KEY,reservation.getCustomerId(),reservation);
        return reservation;
    }

    public Reservation findReservationByID(String id) {
        return (Reservation) template.opsForHash().get(HASH_KEY, id);

    }

}
