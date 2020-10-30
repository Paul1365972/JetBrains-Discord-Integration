/*
 * Copyright 2017-2020 Aljoscha Grebe
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

package com.almightyalpaca.jetbrains.plugins.discord.plugin.render

import com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.settings

class ProjectRenderer(context: RenderContext) : Renderer(context) {
    override fun RenderContext.render() = render(
        details = settings.projectDetails,
        detailsCustom = settings.projectDetailsCustom,
        state = settings.projectState,
        stateCustom = settings.projectStateCustom,
        largeIcon = settings.projectIconLarge,
        largeIconText = settings.projectIconLargeText,
        largeIconTextCustom = settings.projectIconLargeTextCustom,
        smallIcon = settings.projectIconSmall,
        smallIconText = settings.projectIconSmallText,
        smallIconTextCustom = settings.projectIconSmallTextCustom,
        startTimestamp = settings.projectTime,
        timestampCustom = settings.timeCustom,
        timestampOverride = settings.timeOverride
    )
}
