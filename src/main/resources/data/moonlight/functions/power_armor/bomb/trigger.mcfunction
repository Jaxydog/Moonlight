summon minecraft:creeper ~ ~ ~ {powered: 1, Fuse: 60, ignited: 1, Invulnerable: 1b, NoAI: 1b, Tags: ["powerArmorBomb"], ActiveEffects: [{Id: 14, Duration: 100, ShowParticles: 0b}]}
particle minecraft:flash ~ ~ ~ 0 0 0 0 1 normal @a
playsound minecraft:block.iron_trapdoor.open player @a ~ ~ ~ 1 0.5
playsound minecraft:block.iron_trapdoor.close player @a ~ ~ ~ 1 0.5