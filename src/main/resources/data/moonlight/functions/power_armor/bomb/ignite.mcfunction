execute positioned as @e[tag=powerArmorBomb,limit=1,sort=nearest] run particle minecraft:smoke ~ ~1 ~ 1 1 1 0.1 500 normal @a
execute positioned as @e[tag=powerArmorBomb,limit=1,sort=nearest] run particle minecraft:small_flame ~ ~1 ~ 0.5 0.5 0.5 0.1 100 normal @a
execute positioned as @e[tag=powerArmorBomb,limit=1,sort=nearest] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 normal @a
execute positioned as @e[tag=powerArmorBomb,limit=1,sort=nearest] run playsound minecraft:block.beacon.activate player @a ~ ~ ~ 2 2
execute positioned as @e[tag=powerArmorBomb,limit=1,sort=nearest] run playsound minecraft:item.trident.riptide_3 player @a ~ ~ ~ 2 2
effect clear @e[tag=powerArmorBomb,limit=1,sort=nearest] invisibility