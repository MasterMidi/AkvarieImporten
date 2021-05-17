SELECT fish_pack.id AS fish_pack_id, 
fish_pack.birthday AS fish_pack_birthday, 
fish_pack.pack_number AS fish_pack_number, 
fish_pack.status AS fish_pack_status, 
fish_pack.fish_specie_id AS species_id, 
fish_pack.feeding_plan_id AS feeding_plan_id, 

--FISHPACK PERIOD
fish_pack_period.id as period_id, 
fish_pack_period.aquarium_id as period_aquarium_id, 
fish_pack_period.end_date as period_end_date, 
fish_pack_period.start_date,

-- AQUARIUM
aquarium.id AS aquarium_id, 
aquarium.location_id AS aquarium_location_id, 
aquarium.expense_id AS aquarium_expense_id, 
aquarium.number AS aquarium_number, 
aquarium.size AS aquarium_size,

--FEEDINGPLAN

feeding_plan.id AS feeding_plan_id, 
feeding_plan.name AS feeding_plan_name, 
feeding_plan.interval AS feeding_plan_interval, 
feeding_plan.amount AS feeding_plan_amount,

--FISH SPECIES
fish_species.id AS species_id, 
fish_species.name AS species_name, 
fish_species.average_eggs AS species_average_eggs, 
fish_species.birth_size AS species_birth_size, 
fish_species.grow_rate AS species_grow_rate, 
fish_species.minimum_sale_size AS species_minimum_sale_size


FROM fish_pack
JOIN fish_pack_period ON fish_pack_period.id = (SELECT TOP 1 id FROM fish_pack_period WHERE end_date is null AND fish_pack_id = fish_pack.id ORDER BY fish_pack_period.start_date DESC)
JOIN aquarium ON aquarium.id = fish_pack_period.id
JOIN feeding_plan ON fish_pack.feeding_plan_id = feeding_plan.id
JOIN fish_species ON fish_pack.fish_specie_id = fish_species.id
WHERE pack_number like ?