package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.persistence.HabitQuantity;
import com.habitproject.persistence.HabitRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final HabitRepository habitRepository;
    public AppServiceImpl(HabitRepository repository) {
        this.habitRepository = repository;
    }

    /**
     * saving a new habit to database
     * @param tag - a tag for the habit (name)
     * @param quantity - quantity of the habit
     * @param frequency - the frequency a habit should be reached
     * @param userId - id of the user the Habit belongs to
     * @return newly created habit
     */
    @Override
    public HabitEntity putHabit(String tag, HabitQuantity quantity, Integer frequency, Long userId) {
        HabitEntity newHabit = new HabitEntity(tag, quantity, frequency, userId);
        habitRepository.saveAndFlush(newHabit);
        return newHabit;
    }

    /**
     * getting one HabitEntity by id
     * @param id - the habit id to select
     * @return selected HabitEntity
     */
    @Override
    public HabitEntity getHabit(Long id) {
        return habitRepository.getOne(id);
    }

    /**
     * getting a list of all habits by UserID
     * @param userId - the user ID to be selected by
     * @return list of HabitEntities
     */
    @Override
    public List<HabitEntity> getAllHabit(Long userId) {
        return habitRepository.findAllByUserId(userId);
    }

    /**
     * updating a HabitEntity in the database
     * @param id - id of the habit to update
     * @param tag - a tag for the habit (name)
     * @param quantity - quantity of the habit
     * @param frequency - the frequency a habit should be reached
     * @return updated habit
     */
    @Override
    public HabitEntity patchHabit(Long id, String tag, HabitQuantity quantity, Integer frequency) {
        habitRepository.updateHabitByID(id, tag, quantity,frequency);
        habitRepository.flush();
        return habitRepository.getOne(id);
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param id - id of the habit that should be deleted
     * @return deleted habit
     */
    @Override
    public HabitEntity deleteHabit(Long id) {
        var output = habitRepository.getOne(id);
        habitRepository.delete(output);
        habitRepository.flush();
        return output;

    }


}
