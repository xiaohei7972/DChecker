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
    fun `probe and repository details are localized`() {
        assertEquals(
            "使用 0xDEADBEEF 选项执行 KernelSU 特征 prctl 探针。",
            HomeChineseText.translate("KernelSU magic prctl probe using option 0xDEADBEEF."),
        )
        assertEquals(
            "通过反射检查 XposedBridge.disableHooks 与 XposedBridge.sHookedMethodCallbacks，以确认实时桥接状态，而非仅依赖类残留。",
            HomeChineseText.translate(
                "Reflects XposedBridge.disableHooks and XposedBridge.sHookedMethodCallbacks to confirm live bridge state rather than class residue alone.",
            ),
        )
        assertEquals(
            "创建离屏 EGL 上下文并检查 GL_VENDOR、GL_RENDERER 与 GL_VERSION。",
            HomeChineseText.translate(
                "Builds an off-screen EGL context and inspects GL_VENDOR, GL_RENDERER, and GL_VERSION.",
            ),
        )
        assertEquals("7 个来源", HomeChineseText.translate("7 source(s)"))
        assertEquals("3 条痕迹", HomeChineseText.translate("3 trace(s)"))
        assertEquals("2 个备用读取", HomeChineseText.translate("2 fallback(s)"))
    }

    @Test
    fun `tee deep check details are localized`() {
        assertEquals(
            "由于证明中的信任根缺失，启动一致性检查不可用。",
            HomeChineseText.translate(
                "Boot consistency check unavailable because attested root of trust was missing.",
            ),
        )
        assertEquals(
            "证明中的 verifiedBootHash 与 ro.boot.vbmeta.digest 不一致。",
            HomeChineseText.translate(
                "Attested verifiedBootHash did not match ro.boot.vbmeta.digest.",
            ),
        )
        assertEquals(
            "匹配 • 启动一致性检查不可用。",
            HomeChineseText.translate("Matched • Boot consistency check unavailable."),
        )
        assertEquals("3/5 次可疑运行", HomeChineseText.translate("3/5 suspicious runs"))
        assertEquals("Soter 检查：启动一致性检查不可用。", HomeChineseText.translate("Soter check: Boot consistency check unavailable."))
    }

    @Test
    fun `tee verification probe messages are localized`() {
        assertEquals(
            "设备未声明支持 StrongBox。",
            HomeChineseText.translate("The device does not advertise StrongBox support."),
        )
        assertEquals(
            "StrongBox 允许超过 4 个并发签名句柄。",
            HomeChineseText.translate("StrongBox allowed more than 4 simultaneous signing handles."),
        )
        assertEquals(
            "Grant 自身域私有 Binder 探针要求 Android 12 或更高版本。",
            HomeChineseText.translate("Grant self-domain private binder probe requires Android 12 or newer."),
        )
        assertEquals(
            "ImportKey 支持门槛检查失败：origin=2",
            HomeChineseText.translate("ImportKey support gate failed: origin=2"),
        )
        assertEquals(
            "私有路径：匹配 clean",
            HomeChineseText.translate("Private: matched clean"),
        )
    }

    @Test
    fun `tee keystore probe and multiline export details are localized`() {
        assertEquals(
            "Binder 链一致性探针要求 Android 12 或更高版本。",
            HomeChineseText.translate("Binder chain consistency probe requires Android 12 or newer."),
        )
        assertEquals(
            "公开路径：正常（所有者别名与受授者 Domain.GRANT 的有序完整证书链指纹一致。）",
            HomeChineseText.translate(
                "Public: clean (Owner alias and grantee Domain.GRANT ordered full-chain fingerprints matched.)",
            ),
        )
        assertEquals(
            "第 2 轮 生成失败：Keystore2 服务接口不可用。",
            HomeChineseText.translate("cycle2 generate failed: Keystore2 service interface was unavailable."),
        )
        assertEquals(
            "启动一致性检查不可用。\nro.boot.vbmeta.digest\n设备未声明支持 StrongBox。",
            HomeChineseText.translate(
                "Boot consistency check unavailable.\nro.boot.vbmeta.digest\nThe device does not advertise StrongBox support.",
            ),
        )
    }

    @Test
    fun `tee reducer summaries and multiline raw details are localized`() {
        assertEquals(
            "运行时与证明中的补丁级别在本机一致。",
            HomeChineseText.translate("Runtime and attested patch levels line up locally."),
        )
        assertEquals("3 项不一致", HomeChineseText.translate("3 mismatch(es)"))
        assertEquals(
            "CRL 刷新超时。\nro.boot.vbmeta.digest\nHook 已安装",
            HomeChineseText.translate(
                "CRL refresh timed out.\nro.boot.vbmeta.digest\nHook installed",
            ),
        )
        assertEquals(
            "可能原因：厂商 Binder/libc 兼容性差异。未发现更强的 Hook 指纹。",
            HomeChineseText.translate(
                "Possible cause: vendor binder/libc compatibility differences. No stronger hook fingerprint was found.",
            ),
        )
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
