/*
 * Copyright 2026 Duck Apps Contributor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dchecker.info.features.dashboard.ui.model

import com.dchecker.info.core.ui.model.DetectorStatus
import com.dchecker.info.core.ui.components.HomeChineseText
import org.junit.Assert.assertEquals
import org.junit.Test

class DashboardUiStateTest {

    @Test
    fun `chinese dashboard localizes dynamic danger summary and keeps counts`() {
        val contributions = listOf(
            DashboardDetectorContribution(
                id = "bootloader",
                title = "Bootloader",
                status = DetectorStatus.danger(),
                headline = "2 critical boot integrity signal(s)",
                summary = "Unlocked state needs review.",
                ready = true,
            ),
        )
        val overview = buildDashboardOverview(contributions, chinese = true)
        val findings = buildDashboardFindings(contributions, chinese = true)

        assertEquals("危险", overview.headline)
        assertEquals("请先检查引导加载程序。", overview.summary)
        assertEquals("1", overview.metrics.single { it.label == "危险" }.value)
        assertEquals("发现 2 个严重启动完整性信号", findings.single().headline)
        assertEquals("引导加载程序", findings.single().detectorTitle)
        assertEquals("发现 3 个高风险 LSPosed 信号", HomeChineseText.translate("3 high-risk LSPosed signal(s)"))
        assertEquals("发现 2 个严重挂载信号", HomeChineseText.translate("2 critical mount signal(s)"))
        assertEquals("ro.build.fingerprint", HomeChineseText.translate("ro.build.fingerprint"))
    }

    @Test
    fun `home translates Kotlin assembled detector subtitles without changing evidence`() {
        assertEquals(
            "3 个管理器 · 2 个模块 · 1 条原生痕迹 · 4 项策略信号",
            HomeChineseText.translate("3 manager · 2 module · 1 native · 4 policy"),
        )
        assertEquals(
            "2 个环境信号 · 1 个转译信号 · 0 个运行时信号 · 3 个陷阱命中",
            HomeChineseText.translate("2 env · 1 translation · 0 runtime · 3 trap hit(s)"),
        )
        assertEquals(
            "5 条规则 · 2 项信息 · 0 个原生命中 · 1 项构建信号 · 2 个属性区域缺口",
            HomeChineseText.translate("5 rules · 2 info · 0 native · 1 Build · 2 prop-area hole(s)"),
        )
        assertEquals("/data/adb/modules", HomeChineseText.translate("/data/adb/modules"))
    }

    @Test
    fun `danger tee card status propagates to dashboard overview`() {
        val overview = buildDashboardOverview(
            contributions = listOf(
                DashboardDetectorContribution(
                    id = "tee",
                    title = "TEE",
                    status = DetectorStatus.danger(),
                    headline = "Attestation aligned; local probes need review",
                    summary = "ImportKey retained attestation narrative detected.",
                    ready = true,
                ),
                DashboardDetectorContribution(
                    id = "bootloader",
                    title = "Bootloader",
                    status = DetectorStatus.allClear(),
                    headline = "Locked",
                    summary = "Bootloader state is locked.",
                    ready = true,
                ),
            ),
        )

        assertEquals(DetectorStatus.danger(), overview.status)
        assertEquals("Danger", overview.headline)
        assertEquals("1", overview.metrics.single { it.label == "Danger" }.value)
    }

    @Test
    fun `danger contribution after warning still dominates dashboard overview`() {
        val overview = buildDashboardOverview(
            contributions = listOf(
                DashboardDetectorContribution(
                    id = "soter",
                    title = "Soter",
                    status = DetectorStatus.warning(),
                    headline = "Local review",
                    summary = "Soter local environment needs review.",
                    ready = true,
                ),
                DashboardDetectorContribution(
                    id = "tee",
                    title = "TEE",
                    status = DetectorStatus.danger(),
                    headline = "Attestation aligned; local probes need review",
                    summary = "UpdateSubcomponent stale TEE response persistence detected.",
                    ready = true,
                ),
            ),
        )

        assertEquals(DetectorStatus.danger(), overview.status)
        assertEquals("Danger", overview.headline)
        assertEquals("1", overview.metrics.single { it.label == "Danger" }.value)
    }

    @Test
    fun `top findings use compact finding detail when detector provides one`() {
        val findings = buildDashboardFindings(
            contributions = listOf(
                DashboardDetectorContribution(
                    id = "tee",
                    title = "TEE",
                    status = DetectorStatus.danger(),
                    headline = "Attestation aligned; local probes need review",
                    summary = "Grant self-domain certificate-chain split detected. Public: clean | Hidden: clean | Private: split.",
                    findingDetail = "Grant self-domain certificate chain diverged; open TEE details for stage diagnostics.",
                    ready = true,
                ),
            ),
        )

        assertEquals(
            "Grant self-domain certificate chain diverged; open TEE details for stage diagnostics.",
            findings.single().detail,
        )
    }
}
