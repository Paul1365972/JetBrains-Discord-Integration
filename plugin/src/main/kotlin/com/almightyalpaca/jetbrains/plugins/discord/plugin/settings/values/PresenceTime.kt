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

package com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.values

import com.almightyalpaca.jetbrains.plugins.discord.plugin.render.RenderContext
import com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.options.types.SimpleValue
import com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.options.types.ToolTipProvider

typealias TimeValue = SimpleValue<PresenceTime>

enum class PresenceTime(val description: String, override val toolTip: String? = null) : ToolTipProvider {
    APPLICATION("Application") {
        override fun RenderContext.getResult() = applicationData?.applicationStartTime.toResult()
    },
    PROJECT("Project") {
        override fun RenderContext.getResult() = projectData?.applicationStartTime.toResult()
    },
    FILE("File") {
        override fun RenderContext.getResult() = fileData?.applicationStartTime.toResult()
    },
    CUSTOM("Custom") {
        override fun RenderContext.getResult() = Result.Custom
    },
    HIDE("Hide") {
        override fun RenderContext.getResult() = Result.Empty
    };

    protected abstract fun RenderContext.getResult(): Result

    fun get(context: RenderContext) = context.run { getResult() }

    override fun toString() = description

    companion object {
        val Application = APPLICATION to arrayOf(APPLICATION, CUSTOM, HIDE)
        val Project = APPLICATION to arrayOf(APPLICATION, PROJECT, CUSTOM, HIDE)
        val File = APPLICATION to arrayOf(APPLICATION, PROJECT, FILE, CUSTOM, HIDE)
    }

    fun Long?.toResult() = when (this) {
        null -> Result.Empty
        else -> Result.Time(this)
    }

    sealed class Result {
        object Empty : Result()
        object Custom : Result()
        data class Time(val value: Long) : Result()
    }
}
