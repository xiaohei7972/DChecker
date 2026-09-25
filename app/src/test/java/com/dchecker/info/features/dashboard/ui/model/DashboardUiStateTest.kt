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
        assertEquals("已列出 18 个服务。", HomeChineseText.translate("Listed 18 services."))
        assertEquals("一致（3 个来源）", HomeChineseText.translate("Consistent (3)"))
        assertEquals("来源：native libc", HomeChineseText.translate("Source: native libc"))
        assertEquals(
            "属性区、序列号与残留值检查未发现异常；已检查 8 个跟踪属性名，覆盖 2 个属性区上下文。",
            HomeChineseText.translate(
                "Tracked property area, serial, and residual value checks were clean; checked 8 tracked property name(s) across 2 property-area context(s)",
            ),
        )
    }

    @Test
    fun `home translates remaining detector card copy`() {
        assertEquals(
            "检测到 HMA 类隐藏行为",
            HomeChineseText.translate("HMA-style concealment detected"),
        )
        assertEquals(
            "正在收集类、ClassLoader、Binder、运行时痕迹、logcat、应用包、SELinux 策略和原生运行时证据。",
            HomeChineseText.translate(
                "Gathering class, ClassLoader, Binder, runtime-artifact, logcat, package, SELinux policy, and native runtime evidence.",
            ),
        )
        assertEquals(
            "强制模式，发现异常 sepolicy 规则",
            HomeChineseText.translate("Enforcing with dirty sepolicy rule"),
        )
        assertEquals(
            "系统属性检测覆盖受限",
            HomeChineseText.translate("System property scan has reduced coverage"),
        )
        assertEquals(
            "跨进程辅助器",
            HomeChineseText.translate("Cross-process helper"),
        )
        assertEquals(
            "辅助",
            HomeChineseText.translate("Support"),
        )
        assertEquals(
            "/proc/self/attr/current",
            HomeChineseText.translate("/proc/self/attr/current"),
        )
    }

    @Test
    fun `expanded detector details are localized without rewriting raw evidence`() {
        assertEquals("启动状态", HomeChineseText.translate("Boot state"))
        assertEquals("检测方法", HomeChineseText.translate("Detection methods"))
        assertEquals("策略分析", HomeChineseText.translate("Policy analysis"))
        assertEquals("审计完整性", HomeChineseText.translate("Audit integrity"))
        assertEquals("TEE 详情", HomeChineseText.translate("TEE details"))
        assertEquals(
            "用于调试、分享和人工核验的结构化导出。",
            HomeChineseText.translate("Structured export for debugging, sharing, and manual verification."),
        )
        assertEquals("查看目标应用（28）", HomeChineseText.translate("View target apps (28)"))
        assertEquals(
            "结果：/data/adb/modules/example",
            HomeChineseText.translate("Result: /data/adb/modules/example"),
        )
        assertEquals(
            "/data/adb/modules/example",
            HomeChineseText.translate("/data/adb/modules/example"),
        )
    }

    @Test
    fun `expanded detector content is localized`() {
        assertEquals("启动状态", HomeChineseText.translate("Boot state"))
        assertEquals("检测方法", HomeChineseText.translate("Detection methods"))
        assertEquals("扫描摘要", HomeChineseText.translate("Scan summary"))
        assertEquals("运行时痕迹", HomeChineseText.translate("Runtime artifacts"))
        assertEquals("审计完整性", HomeChineseText.translate("Audit integrity"))
        assertEquals("TEE 详情", HomeChineseText.translate("TEE details"))
        assertEquals(
            "此检测器会检查符号解析、函数入口字节、可执行内存映射、可疑 memfd 或已删除库、信号处理器以及加载器可见性。",
            HomeChineseText.translate(
                "This detector checks symbol resolution, function entry bytes, executable mappings, suspicious memfd or deleted libraries, signal handlers, and loader visibility.",
            ),
        )
        assertEquals(
            "第三方固件可能会合理地修改构建属性、属性存储、引导加载程序状态、特权服务和默认安全设置。",
            HomeChineseText.translate(
                "Aftermarket firmware can legitimately alter build properties, property storage, bootloader state, privileged services, and security defaults.",
            ),
        )
    }

    @Test
    fun `remaining expanded detail labels are localized`() {
        assertEquals("策略版本", HomeChineseText.translate("Policy version"))
        assertEquals("进程上下文", HomeChineseText.translate("Process context"))
        assertEquals("Root 守护进程", HomeChineseText.translate("Root daemons"))
        assertEquals("完整属性审计", HomeChineseText.translate("Full property audit"))
        assertEquals("应用包可见性", HomeChineseText.translate("Package visibility"))
        assertEquals("强信号", HomeChineseText.translate("Strong signals"))
        assertEquals("ClassLoader 命中", HomeChineseText.translate("ClassLoader hits"))
        assertEquals("HMA 不一致", HomeChineseText.translate("HMA mismatch"))
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
