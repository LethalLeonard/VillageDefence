package com.lethalleonard.villagedefence.MobWaves;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class mobSpawning
{
    public static final int baseSpawnCreeper = 4;
    public static final int baseSpawnZombie = 10;
    public static final int baseSpawnEnderman = 2;
    public static double difficulty = 0;


    @SubscribeEvent
    public void spawnMobs(WorldTickEvent event)
    {
        //makes it so that it's called at the end of the tick, only in the overworld, and serverside
        if(event.phase == TickEvent.Phase.END && event.world.provider.getDimension() == 0
                && event.side == Side.SERVER && event.world.playerEntities.size() > 0)
        {
            //fires at 10PM every in-game day
            if(event.world.getWorldTime()%23999 == 16000)
            {
                //gets a list of all players in-game
                List<EntityPlayer> players = event.world.playerEntities;
                ArrayList<BlockPos> spawnpoints = new ArrayList<>();

                //gets the current day in-game
                int currDay = DifficultyScaling.getCurrDay(event.world);
                Random rand = new Random();

                if(DifficultyScaling.getCurrWeek(event.world) > 0)
                {
                    //sets the current difficulty
                    difficulty = DifficultyScaling.getDifficulty(currDay);

                    //populates spawnpoints... creates 5 spawnpoints around each players
                    for (int i = 0; i < players.size(); i++)
                    {
                        BlockPos playerPos = players.get(i).getPosition();
                        for (int k = 0; k < 5; k++)
                        {
                            int x = playerPos.getX(), y, z = playerPos.getZ();

                            x = rand.nextInt(60) - 30 + x;
                            z = rand.nextInt(60) - 30 + z;
                            y = event.world.getHeight(x, z);

                            spawnpoints.add(new BlockPos(x, y, z));
                        }
                    }

                    //Sets the adjusted amount of mobs
                    int creepersToSpawn = (int) (baseSpawnCreeper * (difficulty + (players.size() - 1) * 1.2));
                    int zombiesToSpawn = (int) (baseSpawnZombie * (difficulty + (players.size() - 1) * 1.2));
                    int endermenToSpawn = (int) (baseSpawnEnderman * (difficulty + (players.size() - 1) * 1.2));
                    int totalMobsToSpawn = creepersToSpawn + zombiesToSpawn + endermenToSpawn;

                    spawnMobs(event.world, spawnpoints, players, zombiesToSpawn, endermenToSpawn, creepersToSpawn);

                    for(int i = 0; i < players.size(); i++)
                        players.get(i).sendMessage(new TextComponentString("Number of mobs spawned: " + totalMobsToSpawn));
                }
                //goes through the playerlist and messages them that it's 10pm at 10pm
                for(int k = 0; k < players.size(); k++)
                {
                    players.get(k).sendMessage(new TextComponentString("Time: " + (event.world.getWorldTime()%24000)/10));
                    players.get(k).sendMessage(new TextComponentString("Day: " + DifficultyScaling.getCurrDay(event.world)));
                    players.get(k).sendMessage(new TextComponentString("Week: " + DifficultyScaling.getCurrWeek(event.world)));

                }
            }
        }
    }

    public void spawnMobs(World world, ArrayList<BlockPos> spawnpoints, List<EntityPlayer> players, int zToSpawn, int eToSpawn, int cToSpawn)
    {
        Random rand = new Random(0);
        EntityCreeper creeper;
        EntityEnderman enderman;
        EntityZombie zombie;
        for(int i = 0; i < cToSpawn;i++)
        {
            BlockPos randSpawnpoint = spawnpoints.get(rand.nextInt(spawnpoints.size()));
            creeper = new EntityCreeper(world);
            creeper.setLocationAndAngles(
                    randSpawnpoint.getX(),
                    randSpawnpoint.getY(),
                    randSpawnpoint.getZ(),
                    0,0);

            creeper.setAttackTarget(getNearestPlayer(creeper,players));

            if(!world.isRemote)
                world.spawnEntity(creeper);
        }

        for(int i = 0; i < zToSpawn;i++)
        {
            BlockPos randSpawnpoint = spawnpoints.get(rand.nextInt(spawnpoints.size()));
            zombie = new EntityZombie(world);
            zombie.setLocationAndAngles(
                    randSpawnpoint.getX(),
                    randSpawnpoint.getY(),
                    randSpawnpoint.getZ(),
                    0,0);

            zombie.setAttackTarget(getNearestPlayer(zombie,players));

            if(!world.isRemote)
                world.spawnEntity(zombie);
        }

        for(int i = 0; i < eToSpawn;i++)
        {
            BlockPos randSpawnpoint = spawnpoints.get(rand.nextInt(spawnpoints.size()));
            enderman = new EntityEnderman(world);
            enderman.setLocationAndAngles(
                    randSpawnpoint.getX(),
                    randSpawnpoint.getY(),
                    randSpawnpoint.getZ(),
                    0,0);

            enderman.setAttackTarget(getNearestPlayer(enderman,players));

            if(!world.isRemote)
                world.spawnEntity(enderman);
        }

    }

    private EntityPlayer getNearestPlayer(Entity entity, List<EntityPlayer> players)
    {
        int[] distances = new int[players.size()];
        int closestPlayer = 0;
        for(int i = 0; i < distances.length; i++)
        {
            BlockPos entityPos = entity.getPosition();
            int x,z;
            x = entityPos.getX();
            z = entityPos.getZ();

            distances[i] = (int)Math.sqrt(x+z);
        }

        for(int i = 0; i < distances.length; i++)
        {
            if(distances[i] < distances[closestPlayer])
                closestPlayer = i;
        }
        return players.get(closestPlayer);
    }
}
