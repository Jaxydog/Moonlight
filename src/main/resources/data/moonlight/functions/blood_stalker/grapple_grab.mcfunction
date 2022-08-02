playsound minecraft:entity.spider.hurt player @a ~ ~ ~ 0.5 1.2
playsound minecraft:entity.phantom.bite player @a ~ ~ ~ 0.7 2
execute anchored eyes run particle minecraft:dust 0.7 0 0 0.75 ^ ^-0.2 ^ 0.1 0.1 0.1 0 20 normal @a[distance=0.1..]
effect give @s minecraft:slowness 3 9 true
tag @s add bloodStalkerGrapple