/*
 * This file is part of PlaceholderAPI
 *
 * PlaceholderAPI
 * Copyright (c) 2015 - 2024 PlaceholderAPI Team
 *
 * PlaceholderAPI free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlaceholderAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package me.clip.placeholderapi.scheduler;

import me.clip.placeholderapi.scheduler.bukkit.BukkitScheduler;
import me.clip.placeholderapi.scheduler.folia.FoliaScheduler;
import me.clip.placeholderapi.scheduler.paper.PaperScheduler;
import me.clip.placeholderapi.scheduler.scheduling.schedulers.TaskScheduler;
import me.clip.placeholderapi.scheduler.utils.JavaUtil;
import org.bukkit.plugin.Plugin;

public class UniversalScheduler {
    private static final boolean IS_FOLIA = JavaUtil.classExists("io.papermc.paper.threadedregions.RegionizedServer");
    private static final boolean IS_CANVAS = JavaUtil.classExists("io.canvasmc.canvas.server.ThreadedServer");
    private static final boolean IS_EXPANDED_SCHEDULING_AVAILABLE = JavaUtil.classExists("io.papermc.paper.threadedregions.scheduler.ScheduledTask");

    public static TaskScheduler getScheduler(Plugin plugin) {
        return IS_FOLIA || IS_CANVAS ? new FoliaScheduler(plugin) : (IS_EXPANDED_SCHEDULING_AVAILABLE ? new PaperScheduler(plugin) : new BukkitScheduler(plugin));
    }

}
