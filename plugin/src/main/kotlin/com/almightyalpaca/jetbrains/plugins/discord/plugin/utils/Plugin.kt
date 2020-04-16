/*
 * Copyright 2017-2019 Aljoscha Grebe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.almightyalpaca.jetbrains.plugins.discord.plugin.utils

import com.intellij.ide.plugins.PluginManagerCore

object Plugin {
    private val pluginId by lazy { PluginManagerCore.getPluginByClassName(Plugin::class.java.name)!! }
    private val plugin by lazy { PluginManagerCore.getPlugin(pluginId)!! }

    fun getId() = pluginId
    fun getIdString() = pluginId.idString

    object Version {
        val isStable by lazy { toString().matches(Regex("""\d+\.\d+\.\d+""")) }
        val isEap by lazy { !isStable }

        override fun toString(): String = plugin.version
    }
}
