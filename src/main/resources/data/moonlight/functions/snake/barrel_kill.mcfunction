execute if entity @e[tag=snakeBarrel] run give @s minecraft:barrel 1
kill @e[tag=snakeBarrel]
stopsound @s player moonlight:origin.snake.sneak
playsound minecraft:block.barrel.close player @s ~ ~ ~ 1 1
