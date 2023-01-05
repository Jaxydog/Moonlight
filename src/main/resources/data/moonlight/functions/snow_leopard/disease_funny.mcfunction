title @s actionbar {"translate": "power.moonlight.snow_leopard.disease.ligma", "color": "yellow"}
effect give @s minecraft:slowness 5 1 true
effect give @s minecraft:blindness 5 1 true
effect give @s minecraft:nausea 5 1 true
effect give @s minecraft:poison 5 0 true
playsound minecraft:entity.lightning_bolt.impact player @s ~ ~ ~ 1 2
playsound minecraft:entity.lightning_bolt.thunder player @s ~ ~ ~ 1 2
playsound minecraft:item.trident.thunder player @s ~ ~ ~ 1 2
playsound moonlight:origin.snow_leopard.scream player @a ~ ~ ~ 1.2 1
playsound moonlight:origin.snow_leopard.scream player @a ~ ~ ~ 1.2 1
playsound moonlight:origin.snow_leopard.scream player @a ~ ~ ~ 1.2 1
execute as @s rotated as @s anchored eyes run particle minecraft:spit ^ ^-0.5 ^0.5 0.1 0.1 0.1 0 5 normal @a
execute as @s rotated as @s anchored eyes run particle minecraft:falling_honey ^ ^-0.5 ^0.5 0.1 0.1 0.1 0 5 normal @a