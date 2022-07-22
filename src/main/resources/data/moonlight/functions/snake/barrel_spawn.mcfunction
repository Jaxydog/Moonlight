clear @s minecraft:barrel 1
summon armor_stand ~ ~-0.5 ~ {Invisible:1b,PersistenceRequired:1b,NoBasePlate:1b,NoGravity:1b,ArmorItems:[{},{},{},{id:"minecraft:barrel",Count:1b}],HandItems:[{},{}],Tags:["snakeBarrel"],DisabledSlots:4144959}
playsound minecraft:block.barrel.open player @s ~ ~ ~ 1 1
playsound moonlight:origin.snake.sneak player @s ~ ~ ~ 0.6 1