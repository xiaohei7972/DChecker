/*
 * Copyright 2026 Duck Apps Contributor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package com.dchecker.info.core.ui.components

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Home-only presentation translations. Detector models, sorting, evidence, and exported reports
 * retain their original values. Match complete phrases so paths, package names, property values,
 * and other raw evidence are never translated by accident.
 */
val LocalHomeChinese = staticCompositionLocalOf { false }

object HomeChineseText {
    private val exact = mapOf(
        // Overview, actions, and detector names.
        "Build Time (UTC)" to "构建时间（UTC）",
        "Export Report" to "导出报告",
        "Running local checks" to "正在运行本地检测",
        "Dashboard summary will unlock when the detector cards finish collecting evidence." to "检测卡片收集完证据后，将显示首页汇总。",
        "Security overview" to "安全概览",
        "Danger" to "危险",
        "Warning" to "警告",
        "Info" to "信息",
        "Ready" to "已完成",
        "Pending" to "等待中",
        "OK" to "正常",
        "High" to "高风险",
        "Warn" to "警告",
        "Check" to "待核查",
        "Clear" to "正常",
        "Top findings" to "重点发现",
        "Priority review queue" to "优先核查项目",
        "Scan status" to "扫描状态",
        "Overview" to "概览",
        "Waiting for detector evidence" to "等待检测证据",
        "No urgent findings in ready modules" to "已完成项目中无紧急发现",
        "Detector cards will expand as modules finish collecting local evidence." to "各模块收集完本地证据后会展开检测卡片。",
        "Detector cards will populate as local checks complete." to "本地检测完成后将显示检测卡片。",
        "Additional modules are still collecting their local evidence." to "部分模块仍在收集本地证据。",
        "Use the detector cards below to inspect local evidence in detail." to "请在下方检测卡片中查看本地证据。",
        "Open detector cards below to review detailed local evidence and secondary checks." to "展开下方检测卡片，查看详细证据及补充检查。",
        "Bootloader" to "引导加载程序",
        "Mount" to "挂载环境",
        "Memory" to "进程内存",
        "LSPosed" to "LSPosed",
        "SELinux" to "SELinux",
        "Dangerous Apps" to "风险应用",
        "Play Integrity Fix" to "Play Integrity Fix",
        "Native Root" to "原生 Root",
        "TEE" to "TEE 安全环境",
        "SU" to "SU 权限",
        "Custom ROM" to "第三方 ROM",
        "Kernel Check" to "内核检测",
        "System Properties" to "系统属性",
        "Virtualization" to "虚拟化",
        "Zygisk" to "Zygisk",
        "Device Info" to "设备信息",
        "Device info" to "设备信息",
        "attestation + boot props + DRM consistency" to "认证 + 启动属性 + DRM 一致性",
        "local bootloader scan failed" to "本地引导加载程序扫描失败",
        "properties + prop integrity + packages + services + native traces" to "属性 + 属性完整性 + 应用包 + 服务 + 原生痕迹",
        "local aftermarket firmware probe failed" to "本地第三方固件检测失败",
        "identity + build + android + runtime + display" to "身份 + 构建信息 + Android + 运行环境 + 显示信息",
        "local device profile unavailable" to "本地设备信息不可用",
        "uname + /proc/version + boot cmdline + CVE heuristic" to "uname + /proc/version + 启动参数 + CVE 启发式检查",
        "local kernel probe failed" to "本地内核检测失败",
        "class + classloader + bridge fields + callbacks + runtime + logcat + binder + zygote gids + policy + native" to "类 + 类加载器 + 桥接字段 + 回调 + 运行环境 + logcat + Binder + Zygote GID + 策略 + 原生检测",
        "local LSPosed/Xposed scan failed" to "本地 LSPosed/Xposed 扫描失败",
        "function entry + maps/smaps + fd + signal + linker" to "函数入口 + maps/smaps + 文件描述符 + 信号 + 链接器",
        "local native probe failed" to "本地原生检测失败",
        "6 native detector families · current-process memory only" to "6 类原生检测 · 仅检查当前进程内存",
        "mounts + mountinfo + maps + statfs + statx" to "挂载 + mountinfo + 内存映射 + statfs + statx",
        "local mount scan failed" to "本地挂载扫描失败",
        "supercall + prctl + setresuid + runtime paths + /proc + isolated mount" to "超级调用 + prctl + setresuid + 运行时路径 + /proc + 隔离挂载",
        "native root scan failed" to "原生 Root 扫描失败",
        "native detector unavailable" to "原生检测不可用",
        "multi-source props + native libc + runtime maps" to "多来源属性 + 原生 libc + 运行时内存映射",
        "local Play Integrity residue scan failed" to "本地 Play Integrity 残留扫描失败",
        "sysfs + getenforce + proc attr + app_zygote zygotePreload seqno + context oracle + policy + audit" to "sysfs + getenforce + 进程属性 + app_zygote 预加载序列 + 上下文验证 + 策略 + 审计",
        "local status probe failed" to "本地状态检测失败",
        "su paths + PATH + adb daemons + native context" to "su 路径 + PATH + adb 守护进程 + 原生上下文",
        "local root probe failed" to "本地 Root 检测失败",
        "security props + raw boot + source cross-checks" to "安全属性 + 原始启动信息 + 多来源交叉核验",
        "local property scan failed" to "本地属性扫描失败",
        "properties + build + runtime artifacts + helper process + honeypots" to "属性 + 构建信息 + 运行时痕迹 + 辅助进程 + 陷阱检测",
        "local virtualization scan failed" to "本地虚拟化扫描失败",
        "cross-process fd trap + linker/maps/heap/seccomp/runtime" to "跨进程文件描述符陷阱 + 链接器/映射/堆/seccomp/运行环境",
        "zygote injection scan failed" to "Zygote 注入扫描失败",

        // Kotlin-generated Home strings that do not come from Android resources.
        "Gathering attestation, verified-boot, and property consistency evidence." to "正在收集设备认证、验证启动与属性一致性证据。",
        "Bootloader scan failed before evidence could be assembled." to "在完成证据整理前，引导加载程序检测已失败。",
        "Attestation RootOfTrust, certificate trust, boot properties, raw androidboot parameters, and Widevine credential consistency checks are collecting local evidence." to "正在收集 RootOfTrust 认证、证书信任、启动属性、原始 androidboot 参数和 Widevine 凭据一致性证据。",
        "System properties, prop integrity, runtime packages/services, framework traces, and resource map checks are collecting local firmware evidence." to "正在收集系统属性、属性完整性、运行时应用/服务、框架痕迹和资源映射等本地固件证据。",
        "Custom ROM scan failed before evidence could be assembled." to "在完成证据整理前，第三方 ROM 检测已失败。",
        "Build properties, property-area integrity, bootloader state, runtime packages or services, framework traces, native symbol traces, or resource map anomalies indicate aftermarket firmware, resetprop-style changes, or an unlocked boot chain." to "构建属性、属性区完整性、引导加载程序状态、运行时应用或服务、框架痕迹、原生符号痕迹或资源映射异常，可能表明存在第三方固件、resetprop 类修改或已解锁的启动链。",
        "No common custom ROM branding, property-area, service, package, framework trace, native symbol trace, or resource map anomaly surfaced from local probes." to "本地探针未发现常见第三方 ROM 品牌、属性区、服务、应用包、框架痕迹、原生符号痕迹或资源映射异常。",
        "Native property-area coverage was unavailable on this build." to "当前构建无法进行原生属性区检查。",
        "Native symbol trace detection only runs on Android 10+." to "原生符号痕迹检测仅支持 Android 10 及以上版本。",
        "Gathering local firmware branding and framework evidence." to "正在收集本地固件品牌和框架证据。",
        "Aftermarket firmware can legitimately alter build properties, property storage, bootloader state, privileged services, and security defaults." to "第三方固件可能会正常修改构建属性、属性存储、引导加载程序状态、特权服务以及安全默认值。",
        "Attestation behavior, Play Integrity, and some banking or DRM apps may differ on custom ROMs or modified boot chains." to "在第三方 ROM 或已修改的启动链上，设备认证、Play Integrity 以及部分银行或 DRM 应用的行为可能不同。",
        "This signal alone does not prove malicious compromise or active root access." to "仅凭这一信号不能证明设备遭到恶意入侵或当前存在 Root 权限。",
        "Native coverage was unavailable on this build, so clean native trace results are not available." to "当前构建无法进行原生检测，因此不能得到原生痕迹的正常结论。",
        "No common aftermarket firmware branding, property-area, or framework traces were found." to "未发现常见第三方固件品牌、属性区或框架痕迹。",
        "Package visibility was scoped, so clean app-level evidence may be incomplete." to "应用可见性受到限制，因此应用层的正常结果可能不完整。",
        "A determined ROM can remove obvious signatures, so absence is not proof of stock firmware." to "经过针对性隐藏的 ROM 可以移除明显特征，因此未发现特征并不能证明设备运行原厂固件。",
        "Native framework trace coverage was unavailable on this build." to "当前构建无法进行原生框架痕迹检测。",
        "This detector checks symbol resolution, function entry bytes, executable mappings, suspicious memfd or deleted libraries, signal handlers, and loader visibility." to "此检测器会检查符号解析、函数入口字节、可执行内存映射、可疑 memfd 或已删除库、信号处理器以及加载器可见性。",
        "Memory detection failed before native evidence could be assembled." to "在完成原生证据整理前，内存检测已失败。",
        "High-risk findings point to hook-like code redirection, suspicious executable mappings, or loader-visible runtime artifacts." to "高风险发现通常指向类似 Hook 的代码重定向、可疑可执行内存映射或加载器可见的运行时痕迹。",
        "Native memory evidence was unavailable, so this card cannot treat the absence of findings as a clean runtime result." to "原生内存证据不可用，因此不能把“未发现异常”视为运行环境正常。",
        "No suspicious evidence surfaced in this memory slice." to "当前内存检查范围内未发现可疑证据。",
        "Native memory evidence was unavailable, so this slice could not be verified." to "原生内存证据不可用，因此无法验证此检查范围。",
        "Gathering local runtime memory evidence." to "正在收集本地运行时内存证据。",
        "Hook-like entry changes, deleted executable loaders, or anonymous signal handlers are stronger runtime tampering signals than filesystem-only artifacts." to "类似 Hook 的函数入口改动、已删除的可执行加载项或匿名信号处理器，比单纯的文件系统痕迹更能说明运行时可能被修改。",
        "This card only sees the current app process, so it should be read together with mount, SU, kernel, and TEE evidence." to "此卡片只能查看当前应用进程，应结合挂载、SU、内核和 TEE 证据一起判断。",
        "The findings here are weaker than a direct hook or deleted loader hit, but they still mean the runtime view is not fully boring." to "这里的发现弱于直接 Hook 或已删除加载项命中，但仍说明运行时环境存在值得核查的异常。",
        "Review findings often come from mapping hygiene, loader visibility, or vDSO consistency rather than a direct redirection primitive." to "待核查项通常来自内存映射、加载器可见性或 vDSO 一致性，而不一定是直接的代码重定向。",
        "The current process did not expose branch-heavy function entries, suspicious executable memfd paths, or loader visibility mismatches." to "当前进程未发现异常分支密集的函数入口、可疑可执行 memfd 路径或加载器可见性不一致。",
        "Native memory evidence was unavailable, so this support-only result should not be treated as clean." to "原生内存证据不可用，因此此辅助结果不能视为正常。",
        "A clean memory slice reduces confidence in in-process runtime hooking only when the native probe ran successfully." to "只有原生探针成功运行时，正常的内存检查结果才能降低当前进程存在运行时 Hook 的可能性。",
        "Mount table, mountinfo, memory maps, filesystem type, and path-based root artifact probes are collecting local evidence." to "正在从挂载表、mountinfo、内存映射、文件系统类型和基于路径的 Root 痕迹探针收集本地证据。",
        "Mount scan failed before evidence could be assembled." to "在完成证据整理前，挂载检测已失败。",
        "Startup preload captured early namespace or mount anomalies before the normal runtime scan settled." to "启动预加载在常规运行时扫描稳定前捕获到了早期命名空间或挂载异常。",
        "Startup preload captured weaker early mount inconsistencies that still merit review." to "启动预加载捕获到了较弱的早期挂载不一致，仍建议核查。",
        "The current app mount view contains root-managed overlays, writable-system behavior, selective shell-tmp concealment, hidden mount inconsistencies, or strong runtime artifacts." to "当前应用的挂载视图中发现 Root 管理的 overlay、系统可写行为、选择性 shell 临时目录隐藏、挂载不一致或明显运行时痕迹。",
        "Gathering runtime mount and filesystem evidence." to "正在收集运行时挂载和文件系统证据。",
        "A direct root token in a visible process mount table is strong evidence of a root-managed mount layer." to "可见进程挂载表中的直接 Root 标记，是 Root 管理挂载层的强证据。",
        "Different processes expose different mount tables to the isolated observer, which can indicate selective mount hiding." to "不同进程向隔离观察者暴露了不同的挂载表，这可能表明存在选择性挂载隐藏。",
        "The isolated helper process did not return cross-process mount view data." to "隔离辅助进程未返回跨进程挂载视图数据。",
        "Mappings" to "内存映射",
        "Hardware-backed" to "硬件支持",
        "Reflection API" to "反射 API",
        "getprop snapshot" to "getprop 快照",
        "Native libc" to "原生 libc",
        "Raw boot params" to "原始启动参数",
        "Source consistency" to "来源一致性",
        "Attest" to "认证",
        "Props" to "属性",
        "Verified" to "已验证",
        "Custom" to "自定义",
        "Unlocked" to "已解锁",
        "Locked?" to "疑似锁定",
        "Software" to "软件级",
        "Factory" to "厂商",
        "Build fields" to "构建字段",
        "Modification" to "修改项",
        "Services" to "服务",
        "Reflection" to "反射",
        "Resource maps" to "资源映射",
        "Platform files" to "平台文件",
        "Recovery scripts" to "Recovery 脚本",
        "Product overlays" to "产品 Overlay",
        "Build fields checked" to "已检查构建字段",
        "Modification props checked" to "已检查修改属性",
        "Prop area contexts" to "属性区上下文",
        "Prop item anomalies" to "属性项异常",
        "Named services checked" to "已检查命名服务",
        "Services listed" to "已列出服务",
        "GOT/PLT resolution" to "GOT/PLT 解析",
        "Entry prologue" to "函数入口序言",
        "maps + smaps" to "maps + smaps",
        "FD-backed code" to "FD 支持的代码",
        "KSU mount" to "KSU 挂载",
        "Magisk mount" to "Magisk 挂载",
        "Root mount" to "Root 挂载",
        "Fresh" to "有效",
        "Stale" to "已过期",
        "Startup preload" to "启动预加载",
        "Preload context" to "预加载上下文",
        "Preload findings" to "预加载发现",
        "Map lines" to "内存映射行数",
        "Maps readable" to "内存映射可读取",
        "statx support" to "statx 支持",
        "Path probes" to "路径探针",
        "Shell tmp view" to "Shell 临时目录视图",
        "Filesystem probes" to "文件系统探针",
        "statx cross-check" to "statx 交叉核验",

        // Remaining Home detector text generated directly from Kotlin.
        "Native Root scan failed" to "原生 Root 检测失败",
        "Temp root exploit (CVE-2026-43499) detected" to "检测到临时 Root 漏洞利用（CVE-2026-43499）",
        "Temp root artifacts detected in /data/local/tmp" to "在 /data/local/tmp 中检测到临时 Root 痕迹",
        "KernelSU and APatch indicators detected" to "检测到 KernelSU 与 APatch 指标",
        "Current app already runs in KernelSU su domain" to "当前应用已运行在 KernelSU su 域中",
        "KernelSU detected via ksu_driver" to "通过 ksu_driver 检测到 KernelSU",
        "KernelSU detected via prctl" to "通过 prctl 检测到 KernelSU",
        "KernelSU indicators detected" to "检测到 KernelSU 指标",
        "APatch indicators detected" to "检测到 APatch 指标",
        "Magisk native indicators detected" to "检测到 Magisk 原生指标",
        "Root indicators detected" to "检测到 Root 指标",
        "Isolated mount drift suggests namespace tampering" to "隔离进程挂载差异提示命名空间可能被修改",
        "Isolated-process namespace drift needs review" to "隔离进程命名空间差异需要核查",
        "KernelSU manager weak fingerprint detected" to "检测到 KernelSU 管理器弱特征",
        "Native root scan has reduced coverage" to "原生 Root 检测覆盖受限",
        "Native probes are collecting read-only supercall, syscall, side-channel, self-process, isolated-process mount drift, manager manifest, path, cgroup, kernel-string, and property evidence." to "原生探针正在收集只读 supercall、系统调用、旁路、自身进程、隔离进程挂载差异、管理器清单、路径、cgroup、内核字符串和属性证据。",
        "Native Root scan failed before evidence could be assembled." to "在完成证据整理前，原生 Root 检测已失败。",
        "Read-only ksu_driver hits, direct syscall hits, self-process IOC, root-manager paths, curated runtime residue paths, /data/local/tmp metadata drift, cgroup/process leakage, unexpected root processes, or isolated-process namespace drift indicate active native root infrastructure." to "只读 ksu_driver 命中、直接系统调用命中、自身进程 IOC、Root 管理器路径、运行时残留路径、/data/local/tmp 元数据差异、cgroup/进程泄露、异常 Root 进程或隔离进程命名空间差异，都可能表明存在活动的原生 Root 基础设施。",
        "Only weaker isolated-process mount drift, cross-process mount view divergence, manager manifest fingerprints, process, cgroup, kernel, property, or metadata residue surfaced. These are review-worthy, but not as strong as direct native probes." to "仅发现较弱的隔离进程挂载差异、跨进程挂载视图不一致、管理器清单特征、进程、cgroup、内核、属性或元数据残留。这些值得核查，但证据强度低于直接原生探针。",
        "This detector relies mostly on JNI-backed native probes. Native coverage was unavailable on this build, and the remaining runtime checks stayed clean." to "此检测器主要依赖 JNI 原生探针。当前构建无法进行原生检测，其余运行时检查未发现异常。",
        "KernelSU read-only supercall, prctl-side probes, KernelPatch side channel, self-process IOC, isolated-process mount drift and cross-process mount view comparison, manager manifest fingerprint, SUSFS side-channel, /data/adb artifacts, curated tmp/system/storage residue paths, /data/local/tmp metadata, root-process audit, cgroup/process leakage, kernel strings, and properties stayed clean." to "KernelSU 只读 supercall、prctl 侧探针、KernelPatch 旁路、自身进程 IOC、隔离进程挂载差异与跨进程挂载视图对比、管理器清单特征、SUSFS 旁路、/data/adb 痕迹、tmp/system/storage 残留路径、/data/local/tmp 元数据、Root 进程审计、cgroup/进程泄露、内核字符串和属性均未发现异常。",
        "Gathering local native root evidence." to "正在收集本地原生 Root 证据。",
        "Reduced coverage lowers confidence without implying a positive root detection." to "检测覆盖不足会降低结论可信度，但并不代表已检测到 Root。",
        "A determined root can still hide or remove residue, so absence of native hits is not proof of a stock device." to "经过针对性隐藏的 Root 环境仍可移除痕迹，因此未发现原生命中并不能证明设备为原厂状态。",
        "Native coverage was unavailable, so this card should not be treated as a strong clean verdict." to "原生检测不可用，因此此卡片不能视为高可信的正常结论。",
        "KSU supercall" to "KSU supercall",
        "KernelSU prctl" to "KernelSU prctl",
        "SUSFS side-channel" to "SUSFS 旁路",
        "Self process IOC" to "自身进程 IOC",
        "Isolated mount drift" to "隔离进程挂载差异",
        "Manager fingerprint" to "管理器特征",
        "Runtime paths" to "运行时路径",
        "Root processes" to "Root 进程",
        "Cgroup leakage" to "Cgroup 泄露",
        "Root-specific properties" to "Root 专用属性",
        "Proc checked" to "已检查进程",
        "Proc denied" to "被拒绝的进程读取",
        "Proc hits" to "进程命中",
        "Self driver FDs" to "自身驱动 FD",
        "Self wrapper FDs" to "自身包装器 FD",
        "Main mnt ns" to "主进程挂载命名空间",
        "Isolated mnt ns" to "隔离进程挂载命名空间",
        "Mount anchor drifts" to "挂载锚点差异",
        "Proc mount views" to "进程挂载视图",
        "Proc view expected" to "预期进程视图",
        "Proc view pids" to "进程视图 PID",
        "Manager package" to "管理器应用",
        "Manager traits" to "管理器特征",
        "Cgroup paths" to "Cgroup 路径",
        "Cgroup visible" to "可见 Cgroup",
        "Cgroup proc" to "Cgroup 进程",
        "Cgroup denied" to "Cgroup 读取拒绝",
        "Cgroup hits" to "Cgroup 命中",
        "Kernel sources" to "内核信息来源",
        "Temp root checked" to "已检查临时 Root",
        "Temp root hits" to "临时 Root 命中",
        "Present" to "存在",

        "Play Integrity Fix scan failed" to "Play Integrity Fix 检测失败",
        "Play Integrity scan has reduced native coverage" to "Play Integrity 检测的原生覆盖受限",
        "Property residue, cross-source drift, and current-process runtime traces are being collected from Java and native probes." to "正在通过 Java 和原生探针收集属性残留、跨来源差异以及当前进程运行时痕迹。",
        "Play Integrity Fix scan failed before evidence could be assembled." to "在完成证据整理前，Play Integrity Fix 检测已失败。",
        "Direct spoof properties or runtime traces suggest active or recently used Play Integrity bypass infrastructure." to "直接伪装属性或运行时痕迹提示当前或近期使用过 Play Integrity 绕过环境。",
        "Only lower-confidence residue or cross-source drift surfaced. This can reflect disabled leftovers, partial cleanup, or source disagreement." to "仅发现低可信残留或跨来源差异，可能来自已停用组件残留、清理不完整或不同读取来源结果不一致。",
        "No catalogued Play Integrity residue property or runtime trace was observed across reflection, getprop, native libc, and maps checks." to "通过反射、getprop、原生 libc 和 maps 检查均未发现已收录的 Play Integrity 残留属性或运行时痕迹。",
        "Java-side checks were clean, but native property and runtime trace coverage was unavailable on this build." to "Java 侧检查未发现异常，但当前构建无法进行原生属性和运行时痕迹检查。",
        "Gathering residue properties and runtime trace evidence for Play Integrity spoof frameworks." to "正在收集 Play Integrity 伪装框架的残留属性和运行时痕迹证据。",
        "Persisted spoof properties are relatively strong evidence because they survive process restarts and are readable from multiple layers." to "持久化伪装属性属于较强证据，因为它们可跨进程重启保留，并可从多个层级读取。",
        "Source mismatches mean property APIs disagree. That often points to hook-based translation, cleanup drift, or framework/native divergence." to "来源不一致表示不同属性 API 返回不同结果，通常提示基于 Hook 的转换、清理残留或框架层与原生层不一致。",
        "Runtime traces in current-process maps can indicate bypass code, deleted artifacts, or keystore-adjacent tampering still touching the app process." to "当前进程 maps 中的运行时痕迹可能表明绕过代码、已删除残留或与 Keystore 相邻的修改仍影响应用进程。",
        "No common Play Integrity Fix residue surfaced from the current property catalog or runtime trace heuristics." to "当前属性目录和运行时痕迹启发式检查未发现常见 Play Integrity Fix 残留。",
        "No Play Integrity Fix residue surfaced from Java-side checks, but native libc and maps coverage was unavailable." to "Java 侧未发现 Play Integrity Fix 残留，但原生 libc 与 maps 检测不可用。",
        "Absence of residue is not proof of stock state. A determined bypass can clean properties and avoid obvious in-process traces." to "未发现残留并不能证明设备为原厂状态；针对性绕过方案可以清理属性并避开明显的进程内痕迹。",
        "Spoof control" to "伪装控制",
        "Pixel props" to "Pixel 属性",
        "Device spoof" to "设备伪装",
        "Reflection/getprop/native alignment" to "反射/getprop/原生读取一致性",
        "Maps runtime trace" to "Maps 运行时痕迹",
        "Native libc residue" to "原生 libc 残留",

        "Virtualization scan failed" to "虚拟化检测失败",
        "Virtualization scan has reduced coverage" to "虚拟化检测覆盖受限",
        "Properties, Build fields, runtime artifacts, startup preload, helper-process consistency, and native or ASM honeypots are collecting local evidence." to "正在通过属性、Build 字段、运行时痕迹、启动预加载、辅助进程一致性以及原生/ASM 蜜罐收集本地证据。",
        "Virtualization scan failed before evidence could be assembled." to "在完成证据整理前，虚拟化检测已失败。",
        "No direct emulator, AVF guest, native-bridge, or cross-process drift artifact surfaced from the current app context." to "当前应用环境未发现直接模拟器、AVF 客体、原生桥或跨进程差异痕迹。",
        "Gathering current-process guest and translation evidence." to "正在收集当前进程的虚拟客体与转译证据。",
        "Unavailable helper or native paths reduce confidence without implying a positive detection." to "辅助进程或原生检查路径不可用会降低结论可信度，但不代表已检测到虚拟化。",
        "Cross-process helper" to "跨进程辅助器",
        "Isolated helper" to "隔离进程辅助器",
        "Maps scanned" to "已扫描 Maps",
        "Dex paths" to "DEX 路径",
        "Dex path hits" to "DEX 路径命中",
        "Mount anchor drift" to "挂载锚点差异",
        "Isolated consistency" to "隔离进程一致性",
        "Syscall pack" to "系统调用探针组",
        "Syscall pack hits" to "系统调用探针命中",
        "Dex and classpath" to "DEX 与类路径",
        "UID identity" to "UID 标识",
        "Native bridge" to "原生桥",
        "Cross-process consistency" to "跨进程一致性",
        "Isolated-process consistency" to "隔离进程一致性",
        "Host apps" to "宿主应用",
        "Native honeypots" to "原生蜜罐",
        "ASM honeypots" to "ASM 蜜罐",
        "Sacrificial syscall pack" to "牺牲式系统调用探针组",

        "Zygisk detection failed before evidence could be assembled." to "在完成证据整理前，Zygisk 检测已失败。",
        "The detector is collecting cross-process specialization evidence first, then correlating environment, linker, namespace, maps, smaps, thread, fd, stack, seccomp, and heap traces from the current process." to "检测器会先收集跨进程特化证据，再结合当前进程的环境、链接器、命名空间、maps、smaps、线程、FD、栈、seccomp 和堆痕迹进行分析。",
        "FD trap or direct runtime probes exposed evidence consistent with TMP_PATH leakage, specialization tampering, namespace bypass, linker redirection, ptrace attachment, or libc-hook side effects." to "FD 陷阱或直接运行时探针发现了与 TMP_PATH 泄露、特化篡改、命名空间绕过、链接器重定向、ptrace 附加或 libc Hook 副作用一致的证据。",
        "Only heuristic residue surfaced, so this result should be read together with Memory and Mount before treating it as a confirmed Zygisk runtime." to "仅发现启发式残留，因此应结合 Memory 与 Mount 检测结果后再判断是否存在 Zygisk 运行时。",
        "The FD trap stayed clean and the native runtime snapshot did not expose TMP_PATH, linker, maps, heap, thread, or descriptor traces associated with Zygisk-style injection." to "FD 陷阱未发现异常，原生运行时快照也未发现与 Zygisk 注入相关的 TMP_PATH、链接器、maps、堆、线程或描述符痕迹。",
        "One or more major scan paths were unavailable, so this card cannot treat the absence of hits as a clean runtime result." to "一个或多个主要检测路径不可用，因此不能把“未命中”视为运行环境正常。",
        "Balanced policy: FD trap or any direct runtime strong hit is red, one heuristic-only family is yellow, converging heuristic families also escalate to red." to "平衡策略：FD 陷阱或任意直接运行时强信号记为红色；单一启发式类别记为黄色；多个启发式类别同时命中也会升级为红色。",
        "Independent runtime or cross-process evidence is present." to "存在独立的运行时或跨进程证据。",
        "Only weaker corroboration probes fired." to "仅有较弱的辅助探针命中。",
        "Both major paths completed without positive evidence." to "两条主要检测路径均已完成且未发现阳性证据。",
        "A major scan path was unavailable, so the result is not treated as clean." to "主要检测路径之一不可用，因此结果不能视为正常。",
        "Direct strong signals include FD trap, NeoZygisk TMP_PATH leakage, namespace bypass, linker hook, TracerPid, and seccomp trap positives." to "直接强信号包括 FD 陷阱、NeoZygisk TMP_PATH 泄露、命名空间绕过、链接器 Hook、TracerPid 以及 seccomp 陷阱阳性。",
        "Heuristic probes cover solist drift, maps and smaps anomalies, atexit routing, stack residue, suspicious threads or fds, and heap entropy." to "启发式探针覆盖 solist 差异、maps/smaps 异常、atexit 路由、栈残留、可疑线程或 FD 以及堆熵。",
        "Collecting the cross-process FD trap result and the native runtime snapshot in parallel." to "正在并行收集跨进程 FD 陷阱结果与原生运行时快照。",
        "A red result means this process exposed direct runtime evidence or the cross-process specialization path behaved like a Zygisk-sanitized child process." to "红色结果表示当前进程暴露了直接运行时证据，或跨进程特化路径表现得像经过 Zygisk 清洗的子进程。",
        "Yellow means only weaker corroboration traces were found, not a single decisive runtime primitive on their own." to "黄色表示仅发现较弱的辅助痕迹，单独来看并不是决定性的运行时证据。",
        "Read this together with Memory and Mount, which can still surface loader and mapping residue in parallel." to "请结合 Memory 与 Mount 一起查看，它们还可能从加载器和内存映射角度发现并行残留。",
        "No direct runtime or converging heuristic signal surfaced in the current app process." to "当前应用进程未发现直接运行时信号或相互印证的启发式信号。",
        "A clean result reduces confidence in active Zygisk-style tampering for this process, but it does not prove the whole device is stock." to "正常结果会降低当前进程存在 Zygisk 式篡改的可能性，但不能证明整台设备处于原厂状态。",
        "The detector completed, but at least one major path was unavailable, so this result is support-only rather than clean." to "检测已完成，但至少一条主要路径不可用，因此该结果仅作辅助参考，不能视为正常。",
        "Unavailable service binding, unsupported seccomp or heap helpers, or a missing native snapshot can all reduce confidence without implying a positive detection." to "服务绑定不可用、seccomp 或堆辅助功能不受支持、或缺少原生快照，都会降低结论可信度，但并不代表已检测到异常。",
        "Cross-process" to "跨进程",
        "Native snapshot" to "原生快照",
        "Seccomp syscall trap" to "Seccomp 系统调用陷阱",
        "Linker and namespace" to "链接器与命名空间",
        "Maps and smaps" to "Maps 与 smaps",
        "Solist, atexit, stack, heap" to "Solist、atexit、栈与堆",
        "Support" to "辅助",
        "Medium" to "中等",
        "Partial" to "部分",

        // SELinux / SU / System Properties Kotlin-generated Home text.
        "SELinux scan failed" to "SELinux 检测失败",
        "Checking sysfs, getenforce, /proc/self/attr/current, and app_zygote attr writes before deriving final mode with paradox logic." to "正在检查 sysfs、getenforce、/proc/self/attr/current 和 app_zygote 属性写入，再通过悖论逻辑推导最终模式。",
        "SELinux scan failed before the detector could assemble local evidence." to "在完成本地证据整理前，SELinux 检测已失败。",
        "Permission-denied probes also reinforced the enforcing verdict." to "权限拒绝探针进一步支持 SELinux 处于强制模式的结论。",
        "The zygotePreload app_zygote carrier observed a policyload/access seqno split; treat this as KernelSU-specific evidence bounded to the preload carrier." to "zygotePreload 的 app_zygote 载体观察到 policyload/access 序号分离；这应视为仅限预加载载体范围内的 KernelSU 特定证据。",
        "Recent audit or log markers suggest logd output is being rewritten before apps inspect it." to "近期审计或日志标记提示 logd 输出可能在应用读取前被改写。",
        "Recent audit evidence exposed readable SELinux AVC denial lines, which indicates audit side-channel leakage rather than direct root-process proof." to "近期审计证据暴露了可读取的 SELinux AVC 拒绝记录，这表示存在审计旁路泄露，并非直接证明存在 Root 进程。",
        "Readable auditpatch residue suggests the audit surface may be rewritten." to "可读取的 auditpatch 残留提示审计层可能被改写。",
        "Audit rewrite checks remained non-proving from the current app context." to "从当前应用上下文来看，审计改写检查仍不足以形成确定证据。",
        "The context validity oracle accepted both KSU-specific contexts from the current carrier." to "上下文有效性探针接受了当前载体中的两个 KSU 特定上下文。",
        "The context validity oracle rejected both KSU-specific contexts in live policy." to "上下文有效性探针在当前策略中拒绝了两个 KSU 特定上下文。",
        "The context validity oracle repeated inconsistently, so its KSU verdict was not trusted." to "上下文有效性探针重复结果不一致，因此其 KSU 结论不可信。",
        "The context validity oracle failed its self-test, so its KSU verdict was not trusted." to "上下文有效性探针自检失败，因此其 KSU 结论不可信。",
        "The context validity oracle split across the two KSU-specific contexts." to "上下文有效性探针对两个 KSU 特定上下文给出了不一致结果。",
        "The dedicated app_zygote carrier did not land in the expected app_zygote context, so app_zygote-only SELinux evidence was not trusted." to "专用 app_zygote 载体未进入预期的 app_zygote 上下文，因此仅依赖 app_zygote 的 SELinux 证据不可信。",
        "The dedicated app_zygote carrier failed before the oracle produced a trusted result, so app_zygote-only SELinux coverage was reduced." to "专用 app_zygote 载体在探针产生可信结果前失败，因此 app_zygote 专用 SELinux 检测覆盖受限。",
        "The context validity oracle stayed unavailable." to "上下文有效性探针保持不可用。",
        "SELinux still labels activity, but violations are logged instead of blocked." to "SELinux 仍会标记活动，但违规行为只记录日志而不会阻止。",
        "Mandatory access control is off, so SELinux no longer constrains process behavior." to "强制访问控制已关闭，因此 SELinux 不再限制进程行为。",
        "Local probes did not resolve a stable SELinux mode." to "本地探针未能确定稳定的 SELinux 模式。",
        "Policy enforced" to "策略强制执行",
        "MAC active" to "MAC 已启用",
        "Logging only" to "仅记录日志",
        "Filesystem" to "文件系统",
        "Mounted" to "已挂载",
        "Missing" to "缺失",
        "Paradox logic" to "悖论逻辑",
        "Gathering local status evidence." to "正在收集本地状态证据。",
        "Scan failed." to "检测失败。",
        "Mandatory access control is active." to "强制访问控制已启用。",
        "Policy violations should be blocked and logged." to "违反策略的操作应被阻止并记录日志。",
        "Permission-denied probes acted as positive evidence for enforcing mode." to "权限拒绝探针可作为强制模式的正向证据。",
        "Audit logs appear rewritten, so SELinux denials may look normal even when privileged contexts are present." to "审计日志疑似被改写，因此即使存在特权上下文，SELinux 拒绝记录也可能看起来正常。",
        "Readable SELinux AVC denial lines leaked through the audit surface. This is audit-surface exposure, not direct proof of a root daemon." to "审计层泄露了可读取的 SELinux AVC 拒绝记录。这属于审计层暴露，并非 Root 守护进程的直接证据。",
        "Readable auditpatch residue suggests audit denials could be relabeled or masked." to "可读取的 auditpatch 残留提示审计拒绝记录可能被重新标记或隐藏。",
        "Audit rewrite checks were partially unavailable from this app context." to "当前应用上下文下，部分审计改写检查不可用。",
        "Policy drift may allow some restrictions to be bypassed." to "策略偏差可能允许绕过部分限制。",
        "Policy looks heavily weakened, so enforcement may be ineffective." to "策略看起来被严重削弱，因此强制执行可能失效。",
        "Violations are logged but not blocked." to "违规行为会记录日志，但不会被阻止。",
        "Security-sensitive apps and integrity checks may fail." to "安全敏感应用和完整性检查可能失败。",
        "Mandatory access control is completely disabled." to "强制访问控制已完全关闭。",
        "The device is likely heavily modified or compromised." to "设备可能已被深度修改或存在安全风险。",
        "Local probes were inconclusive." to "本地探针未能得出确定结论。",
        "The app_zygote carrier validated both KSU-specific contexts in live policy." to "app_zygote 载体在当前策略中验证了两个 KSU 特定上下文。",
        "The app_zygote carrier rejected both KSU-specific contexts." to "app_zygote 载体拒绝了两个 KSU 特定上下文。",
        "The zygotePreload app_zygote carrier observed a policyload/access seqno split." to "zygotePreload 的 app_zygote 载体观察到 policyload/access 序号分离。",
        "The zygotePreload app_zygote carrier reported a coherent policyload/access seqno contract." to "zygotePreload 的 app_zygote 载体报告 policyload/access 序号一致。",
        "The zygotePreload app_zygote seqno oracle stayed unavailable." to "zygotePreload 的 app_zygote 序号探针保持不可用。",
        "The dedicated app_zygote carrier rejected the tested privileged contexts with normal EINVAL results." to "专用 app_zygote 载体以正常 EINVAL 结果拒绝了测试的特权上下文。",
        "The dedicated app_zygote attr/current write probe stayed unavailable." to "专用 app_zygote attr/current 写入探针保持不可用。",
        "Strength" to "强度",
        "Class directory unreadable from the current app context." to "当前应用上下文无法读取安全类别目录。",
        "Dangerous types" to "危险类型",
        "Surface" to "审计层",
        "Known auditpatch runtime markers surfaced in recent auditd event logs." to "近期 auditd 事件日志中发现已知 auditpatch 运行时标记。",
        "Recent auditd event logs were readable, but absence of markers is not proof of a clean audit surface." to "近期 auditd 事件日志可读取，但未发现标记并不能证明审计层正常。",
        "The current app could not read recent auditd event logs." to "当前应用无法读取近期 auditd 事件日志。",
        "No matching nonce-tagged controlled AVC denial surfaced in the readable auditd event window." to "在可读取的 auditd 事件窗口中未发现匹配 nonce 标记的受控 AVC 拒绝记录。",
        "No matching controlled AVC denial surfaced in the readable auditd event window, but absence is not proof." to "在可读取的 auditd 事件窗口中未发现匹配的受控 AVC 拒绝记录，但未发现并不构成证明。",
        "su-related AVC" to "与 su 相关的 AVC",
        "No su-related actor string surfaced in the readable canonical AVC window." to "可读取的标准 AVC 窗口中未发现与 su 相关的主体字符串。",
        "Residue paths" to "残留路径",
        "Readable module residue matched common ZN-AuditPatch locations." to "可读取模块残留与常见 ZN-AuditPatch 路径匹配。",
        "No readable auditpatch residue surfaced under common module paths." to "常见模块路径下未发现可读取的 auditpatch 残留。",
        "API level" to "API 级别",
        "Required since" to "最低要求",
        "Strong" to "强",
        "Minor drift" to "轻微偏差",
        "Weak" to "弱",
        "Skipped" to "已跳过",
        "Residue" to "残留",
        "Exposed" to "已暴露",
        "Inconclusive" to "无法确定",
        "Enforcing with dirty sepolicy rule" to "强制模式，发现异常 sepolicy 规则",

        "SU scan failed" to "SU 检测失败",
        "Abnormal root context detected" to "检测到异常 Root 上下文",
        "SU binary detected" to "检测到 SU 可执行文件",
        "File, PATH, adb-daemon, SELinux context, and /proc visibility probes are collecting local evidence." to "正在通过文件、PATH、adb 守护进程、SELinux 上下文和 /proc 可见性探针收集本地证据。",
        "SU scan failed before root evidence could be assembled." to "在完成 Root 证据整理前，SU 检测已失败。",
        "SELinux context probes surfaced abnormal app labels or corroborating root-like process-context residue." to "SELinux 上下文探针发现异常应用标签或可相互印证的类 Root 进程上下文残留。",
        "Common su binaries were found in system or adb-managed locations." to "在系统或 adb 管理的位置发现常见 su 可执行文件。",
        "File and daemon probes were clean, but JNI-backed /proc process enumeration was unavailable." to "文件与守护进程探针未发现异常，但基于 JNI 的 /proc 进程枚举不可用。",
        "Abnormal" to "异常",
        "Normal" to "正常",
        "Suspicious processes" to "可疑进程",
        "Probe path" to "探针路径",
        "Loading" to "加载中",
        "No SELinux context could be read from the current app process." to "无法从当前应用进程读取 SELinux 上下文。",
        "No suspicious process contexts matched root-related tokens." to "未发现与 Root 相关标记匹配的可疑进程上下文。",
        "Native /proc process enumeration was unavailable on this build." to "当前构建无法进行原生 /proc 进程枚举。",
        "JNI syscall scan" to "JNI 系统调用扫描",
        "Fallback self read" to "备用自身读取",
        "Native library was unavailable, so only /proc/self/attr/current fallback could run." to "原生库不可用，因此只能使用 /proc/self/attr/current 备用读取。",
        "Gathering local root evidence." to "正在收集本地 Root 证据。",
        "Privilege-escalation tooling is present or visible from this app context." to "当前应用上下文中存在或可见提权工具。",
        "Root managers can hide files, alter system behavior, and weaken app trust signals." to "Root 管理器可以隐藏文件、修改系统行为并削弱应用的信任信号。",
        "Banking, payment, DRM, and integrity-sensitive apps may refuse to run." to "银行、支付、DRM 和完整性敏感应用可能拒绝运行。",
        "Native SELinux context probes stayed within normal app boundaries." to "原生 SELinux 上下文探针结果保持在正常应用边界内。",
        "This remains heuristic evidence, not proof of an unmodified device." to "这仍属于启发式证据，并不能证明设备未经修改。",
        "File and adb-daemon probes were clean." to "文件与 adb 守护进程探针未发现异常。",
        "Native /proc process-context coverage was unavailable on this build." to "当前构建无法进行原生 /proc 进程上下文检查。",
        "Absence of common SU artifacts is not proof that root is impossible." to "未发现常见 SU 痕迹并不能证明设备不可能存在 Root。",
        "SU paths checked" to "已检查 SU 路径",
        "Daemon paths checked" to "已检查守护进程路径",

        "System Properties scan failed" to "系统属性检测失败",
        "System property scan has reduced coverage" to "系统属性检测覆盖受限",
        "Core security, verified boot, build profile, source consistency, and raw boot cross-checks are collecting local evidence." to "正在收集核心安全属性、验证启动、构建配置、来源一致性和原始启动交叉核验证据。",
        "System property scan failed before evidence could be assembled." to "在完成证据整理前，系统属性检测已失败。",
        "Property values, raw boot contradictions, cross-source drift, cross-check drift, or raw property-area residue indicate insecure build state, spoofing risk, or modified boot context." to "属性值、原始启动矛盾、跨来源差异、交叉核验差异或原始属性区残留，可能表明构建状态不安全、存在伪装风险或启动环境被修改。",
        "No risky property or coherence drift surfaced from available probes, but raw property-area layout coverage was unavailable." to "可用探针未发现高风险属性或一致性差异，但原始属性区布局检查不可用。",
        "Gathering property, boot, and native cross-check evidence." to "正在收集属性、启动和原生交叉核验证据。",
        "Cross-check contradictions mean different system layers disagree about the same boot or build state, which is stronger than a single suspicious value." to "交叉核验矛盾表示不同系统层对同一启动或构建状态给出不同结果，其证据强度高于单个可疑值。",
        "Raw /dev/__properties__ hole residue means the property storage layout no longer matches a normal append-only allocation pattern." to "原始 /dev/__properties__ 空洞残留表示属性存储布局已不再符合正常的追加式分配模式。",
        "Different property APIs returned different values. That can indicate hook-based spoofing, translation issues, or framework/native drift." to "不同属性 API 返回了不同值，这可能表明存在基于 Hook 的伪装、转译问题或框架层/原生层差异。",
        "Observed properties matched conservative expectations, but raw property-area layout coverage was unavailable." to "观察到的属性符合常规预期，但原始属性区布局检查不可用。",
        "Observed key properties matched conservative production expectations across multiple read paths." to "关键属性在多条读取路径上均符合常规量产设备预期。",
        "System properties are still software-readable values, so even aligned results should be combined with kernel, SU, TEE, and package-level signals." to "系统属性仍属于软件可读值，因此即使结果一致，也应结合内核、SU、TEE 和应用包层面的信号一起判断。",
        "Prop areas scanned" to "已扫描属性区",
        "Prop area holes" to "属性区空洞",
        "Info props" to "信息属性",
        "Native property enumeration and shell getprop were both unavailable." to "原生属性枚举与 shell getprop 均不可用。",
        "Union of native foreach keys, shell getprop keys, and JVM getprop keys." to "原生 foreach、shell getprop 与 JVM getprop 键的并集。",
        "Fields where at least two read methods returned different stable values." to "至少两种读取方法返回不同稳定值的字段。",
        "Values that changed between the two read passes and were not reported." to "两次读取之间发生变化且未纳入报告的值。",
        "Java reflection" to "Java 反射",
        "getprop (JVM)" to "getprop（JVM）",
        "Native callback" to "原生回调",
        "Native legacy get" to "原生旧版 get",
        "Native shell getprop" to "原生 shell getprop",
        "Build constant" to "Build 常量",
        "JVM property fallback" to "JVM 属性备用读取",
        "Build constants" to "Build 常量",
        "Prop area layout" to "属性区布局",

        // Shared card sections and short result values.
        "State" to "状态",
        "Security state" to "安全状态",
        "Scan State" to "扫描状态",
        "Security and runtime" to "安全与运行环境",
        "Security spoof" to "安全信息伪装",
        "Status" to "状态",
        "Mode" to "模式",
        "Proof" to "证据",
        "Tier" to "安全级别",
        "Trust" to "信任状态",
        "Trust root" to "信任根",
        "Confidence" to "可信度",
        "Coverage" to "覆盖情况",
        "Critical" to "严重",
        "Review" to "待核查",
        "Clean" to "未发现异常",
        "All clear" to "未发现异常",
        "Failed" to "失败",
        "Error" to "错误",
        "Unavailable" to "不可用",
        "Unknown" to "未知",
        "None" to "无",
        "Yes" to "是",
        "No" to "否",
        "N/A" to "不适用",
        "Loaded" to "已加载",
        "Not observed" to "未观察到",
        "Not resolved yet" to "尚未得到结果",
        "Unsupported" to "不支持",
        "Blocked by seccomp" to "被 seccomp 阻止",
        "Permission denied" to "权限不足",
        "Limited" to "覆盖受限",
        "Captured" to "已获取",
        "Full" to "完整",
        "Scoped" to "受限",
        "Listed" to "已列出",
        "Readable" to "可读取",
        "Unreadable" to "不可读取",
        "Detected" to "已检测到",
        "No signal" to "未发现信号",
        "Strong signals" to "强信号",
        "Heuristic signals" to "启发式信号",
        "Review signals" to "待核查信号",
        "Danger signals" to "危险信号",
        "Signals" to "检测信号",
        "Signal summary" to "信号汇总",
        "Impact" to "可能影响",
        "References" to "参考资料",
        "Detection methods" to "检测方法",
        "Detection Methods" to "检测方法",
        "Detection path" to "检测路径",
        "Evidence source" to "证据来源",
        "Direct confirmation" to "直接证据",
        "Fallback inference" to "补充推断",
        "Context" to "上下文",
        "Runtime" to "运行时",
        "Native" to "原生检测",
        "Packages" to "应用包",
        "Properties" to "属性",
        "Build" to "构建信息",
        "Boot" to "启动状态",
        "Kernel" to "内核",
        "Flags" to "标志",
        "Direct" to "直接证据",
        "Hooks" to "Hook",
        "Targets" to "目标",
        "Hits" to "命中",
        "Hidden" to "已隐藏",
        "PM" to "软件包管理器",
        "Host" to "宿主",
        "ROMs" to "ROM",
        "Identity" to "标识",
        "Behavior" to "行为",
        "Anomalies" to "异常",
        "Artifacts" to "痕迹",
        "Daemons" to "守护进程",
        "Processes" to "进程",
        "Policy" to "安全策略",
        "Audit" to "审计",
        "Certificates" to "证书",
        "Certificate chain" to "证书链",
        "Network" to "网络",
        "Scan summary" to "扫描汇总",
        "Device profile unavailable" to "设备资料不可用",
        "Unknown error" to "未知错误",
        "No findings were produced for this section." to "本节未发现可显示的结果。",
        "No rows were produced for this section on this device." to "此设备上本节没有可显示的检测项。",

        // Card verdicts and explanations shown on Home.
        "Scanning boot state and verified boot evidence" to "正在检查启动状态与验证启动证据",
        "Bootloader scan failed" to "引导加载程序检测失败",
        "Locked and attested verified" to "设备已锁定，认证结果显示验证启动正常",
        "Locked by boot properties" to "启动属性显示设备已锁定",
        "Locked state without full proof" to "设备显示已锁定，但证据不足",
        "Boot state inconclusive" to "启动状态无法确定",
        "Attestation and boot properties stayed aligned with a locked, verified boot chain." to "认证与启动属性一致，均显示已锁定且验证启动正常。",
        "Boot properties look conservative, but the result falls back to software-readable signals because attestation RootOfTrust was unavailable." to "启动属性未见明显异常，但无法取得 RootOfTrust 认证，只能依据软件可读信息判断。",
        "Neither attestation RootOfTrust nor readable boot properties exposed enough data for a confident bootloader verdict." to "RootOfTrust 认证与可读启动属性均不足，无法可靠判断引导加载程序状态。",
        "The boot chain is not obviously broken, but custom-root, software-only, Widevine DRM, or cross-source coherence signals still need review." to "启动链未见明显破坏，但自定义信任根、软件级认证、Widevine DRM 或多来源一致性仍需核查。",
        "Unlocked state, attestation contradictions, broken certificate trust, verified-boot failures, or a corroborated Widevine DRM inconsistency indicate reduced device trust." to "解锁状态、认证矛盾、证书信任异常、验证启动失败或 Widevine DRM 不一致会降低设备可信度。",
        "Scanning runtime mount visibility" to "正在检查运行时挂载视图",
        "No suspicious mount-layer signal" to "未发现可疑挂载信号",
        "A visible process mount table contains a direct root-managed mount token." to "可见进程的挂载表包含由 Root 工具管理的直接痕迹。",
        "Cross-process mount tables diverge from the isolated-process baseline." to "不同进程的挂载表与隔离进程基线不一致。",
        "The mount layer is not obviously compromised, but it still contains review-worthy runtime or filesystem drift." to "挂载层未见明确异常，但运行时或文件系统差异仍需核查。",
        "No suspicious Magisk, overlay, writable-system, or mount-coherence artifact surfaced from the current app context." to "当前应用环境中未发现可疑的 Magisk、overlay、系统可写或挂载一致性痕迹。",
        "Scanning runtime memory" to "正在检查运行时内存",
        "Runtime memory needs review" to "运行时内存需要核查",
        "Memory scan has reduced native coverage" to "内存扫描的原生检测覆盖受限",
        "No hook-like memory signals" to "未发现类似 Hook 的内存信号",
        "No hook-style prologue changes, suspicious executable memfd paths, or loader visibility mismatches surfaced." to "未发现类似 Hook 的函数入口改动、可疑可执行 memfd 路径或加载器可见性差异。",
        "The current process memory stayed mostly clean, but there are still runtime indicators that deserve review." to "当前进程内存总体正常，但仍有运行时指标需要核查。",
        "Scanning LSPosed/Xposed runtime and residue" to "正在检查 LSPosed/Xposed 运行时及残留",
        "Dirty SELinux policy exposes LSPosed rule" to "SELinux 策略暴露了 LSPosed 规则",
        "Dirty SELinux policy signal(s)" to "发现 SELinux 策略异常信号",
        "LSPosed scan has reduced coverage" to "LSPosed 检测覆盖受限",
        "No LSPosed/Xposed runtime signal" to "未发现 LSPosed/Xposed 运行时信号",
        "No Xposed class loading, ClassLoader, callback, Binder bridge, runtime artifact, logcat, stack, maps, or heap traces surfaced in the current app process." to "当前应用进程中未发现 Xposed 类加载、回调、Binder 桥接、运行时痕迹或相关内存映射。",
        "No LSPosed/Xposed signal surfaced from the available probes, but at least one runtime, package, logcat, or native evidence path was unavailable." to "可用探针未发现 LSPosed/Xposed 信号，但部分运行时、应用包、日志或原生证据路径不可用。",
        "Scanning SELinux state" to "正在检查 SELinux 状态",
        "Enforcing" to "强制模式",
        "Permissive" to "宽松模式",
        "Disabled" to "已禁用",
        "Enforcing with audit rewrite" to "强制模式，审计日志疑似被改写",
        "Enforcing with KSU context materialized" to "强制模式，发现 KSU 上下文",
        "Enforcing with app_zygote seqno split" to "强制模式，app_zygote 序号不一致",
        "Enforcing with app_zygote attr-write anomaly" to "强制模式，app_zygote 属性写入异常",
        "Enforcing with untrusted app_zygote carrier" to "强制模式，app_zygote 载体不可信",
        "Enforcing with reduced app_zygote coverage" to "强制模式，app_zygote 检测覆盖受限",
        "Enforcing with unstable context oracle" to "强制模式，上下文探针结果不稳定",
        "Enforcing with untrusted context oracle" to "强制模式，上下文探针不可信",
        "Enforcing with context split" to "强制模式，上下文结果不一致",
        "Enforcing with audit exposure" to "强制模式，审计信息可见",
        "Enforcing with weak policy" to "强制模式，安全策略薄弱",
        "Enforcing with audit risk" to "强制模式，审计存在风险",
        "Enforcing with policy drift" to "强制模式，策略存在偏差",
        "Enforcing with minor drift" to "强制模式，存在轻微偏差",
        "SELinux is enforcing and the visible policy surface looks internally consistent." to "SELinux 处于强制模式，可见的策略检查结果一致。",
        "SELinux is enforcing and only minor policy drift surfaced." to "SELinux 处于强制模式，仅发现轻微策略差异。",
        "SELinux is enforcing, but policy analysis found noticeable drift." to "SELinux 处于强制模式，但策略分析发现明显偏差。",
        "SELinux is enforcing, but the policy looks severely weakened or modified." to "SELinux 处于强制模式，但策略疑似被严重削弱或修改。",
        "Scanning app inventory" to "正在扫描应用清单",
        "Inventory scan failed" to "应用清单扫描失败",
        "Shared storage baseline denied" to "共享存储基线访问被拒",
        "Package inventory unusually small" to "可见应用清单异常偏少",
        "Inventory visibility limited" to "应用清单可见性受限",
        "No known risky packages" to "未发现已知风险应用",
        "No direct virtualization signal" to "未发现直接虚拟化信号",
        "No native root indicators" to "未发现原生 Root 指标",
        "No root indicators" to "未发现 Root 指标",
        "No root indicators from available probes" to "可用探针未发现 Root 指标",
        "No Play Integrity residue surfaced" to "未发现 Play Integrity 绕过残留",
        "No Zygisk runtime signal" to "未发现 Zygisk 运行时信号",
        "No risky property or coherence drift" to "未发现可疑属性或一致性差异",
        "No suspicious kernel markers" to "未发现可疑内核标记",
        "No custom ROM signatures" to "未发现第三方 ROM 特征",
        "No direct virtualization signal surfaced from available probes, but coverage was incomplete." to "可用探针未发现直接虚拟化信号，但检测覆盖不完整。",
        "No common SU binaries or adb root daemons surfaced." to "未发现常见 SU 可执行文件或 adb Root 守护进程。",
        "Common su binaries, adb daemons, and native SELinux context probes stayed clean." to "常见 su 文件、adb 守护进程及原生 SELinux 上下文探针均未发现异常。",
        "Scanning Play Integrity residue" to "正在检查 Play Integrity 绕过残留",
        "Scanning kernel-root indicators" to "正在检查内核级 Root 指标",
        "Scanning root artifacts" to "正在检查 Root 痕迹",
        "Scanning kernel identity" to "正在检查内核标识",
        "Scanning property, boot, and source state" to "正在检查属性、启动和来源状态",
        "Scanning Zygisk runtime traces" to "正在检查 Zygisk 运行时痕迹",
        "Scanning virtualization and translation state" to "正在检查虚拟化和转译状态",
        "Scanning aftermarket firmware signals" to "正在检查第三方固件特征",
        "Collecting local device profile" to "正在收集本地设备资料",
        "Have a good day" to "祝你今天愉快",
        "This card is informational only. It gives you a fixed local profile snapshot to read alongside the detector cards above." to "此卡片仅提供设备信息快照，可与上方检测卡片一起参考。",
        "This card is purely contextual and does not affect detector severity or ranking." to "此卡片仅提供背景信息，不影响检测风险等级或排序。",
        "Cross-process FD trap is positive" to "跨进程 FD 陷阱检测为阳性",
        "One heuristic probe needs review" to "一项启发式探针需要核查",
        "Zygisk result needs more support" to "Zygisk 检测结果需要更多证据",
        "LSPosed scan failed" to "LSPosed 扫描失败",
        "Zygisk scan failed" to "Zygisk 扫描失败",
        "SU scan failed" to "SU 扫描失败",
        "Kernel Check scan failed" to "内核扫描失败",
        "System Properties scan failed" to "系统属性扫描失败",
        "Virtualization scan failed" to "虚拟化扫描失败",
        "Custom ROM scan failed" to "第三方 ROM 扫描失败",
        "Play Integrity Fix scan failed" to "Play Integrity Fix 扫描失败",
        "Native Root scan failed" to "原生 Root 扫描失败",
        "Memory scan failed" to "内存扫描失败",
        "Mount scan failed" to "挂载环境扫描失败",
        "SELinux scan failed" to "SELinux 扫描失败",
        "Root indicators detected" to "检测到 Root 指标",
        "Abnormal root context detected" to "检测到异常 Root 上下文",
        "SU binary detected" to "检测到 SU 可执行文件",
        "Temp root exploit (CVE-2026-43499) detected" to "检测到临时 Root 漏洞利用（CVE-2026-43499）",
        "Temp root artifacts detected in /data/local/tmp" to "在 /data/local/tmp 中发现临时 Root 痕迹",
        "KernelSU and APatch indicators detected" to "检测到 KernelSU 与 APatch 指标",
        "Current app already runs in KernelSU su domain" to "当前应用已运行于 KernelSU su 域",
        "KernelSU detected via ksu_driver" to "通过 ksu_driver 检测到 KernelSU",
        "KernelSU detected via prctl" to "通过 prctl 检测到 KernelSU",
        "KernelSU indicators detected" to "检测到 KernelSU 指标",
        "APatch indicators detected" to "检测到 APatch 指标",
        "Magisk native indicators detected" to "检测到 Magisk 原生指标",
        "Isolated mount drift suggests namespace tampering" to "隔离进程挂载差异提示命名空间可能被修改",
        "Isolated-process namespace drift needs review" to "隔离进程命名空间差异需要核查",
        "KernelSU manager weak fingerprint detected" to "检测到 KernelSU 管理器的弱特征",
        "KernelSU manager package detected" to "检测到 KernelSU 管理器应用包",
        "Native detector unavailable" to "原生探针不可用",
        "Native root scan has reduced coverage" to "原生 Root 检测覆盖受限",
        "Kernel behavior needs review" to "内核行为需要核查",
        "CVE patch state is informational" to "CVE 修复状态仅供参考",
        "CVE patch state inconclusive" to "无法确定 CVE 修复状态",
        "Kernel scan has reduced native coverage" to "内核原生检测覆盖受限",
        "System property scan has reduced coverage" to "系统属性检测覆盖受限",
        "Virtualization scan has reduced coverage" to "虚拟化检测覆盖受限",
        "Custom ROM scan has reduced coverage" to "第三方 ROM 检测覆盖受限",
        "Play Integrity scan has reduced native coverage" to "Play Integrity 原生检测覆盖受限",
        "HMA-style concealment detected" to "检测到 HMA 类隐藏行为",
        "No common aftermarket firmware branding, property-area, or framework traces were found." to "未发现常见第三方固件标识、属性区或框架痕迹。",
        "No common custom ROM branding, property-area, service, package, framework trace, native symbol trace, or resource map anomaly surfaced from local probes." to "本地探针未发现常见第三方 ROM 标识、属性区、服务、应用包、框架、原生符号或资源映射异常。",
        "No direct emulator, AVF guest, native-bridge, or cross-process drift artifact surfaced from the current app context." to "当前应用环境中未发现直接模拟器、AVF 客体、原生桥接或跨进程差异痕迹。",
        "No catalogued Play Integrity residue property or runtime trace was observed across reflection, getprop, native libc, and maps checks." to "反射、getprop、原生 libc 和内存映射检查均未发现已收录的 Play Integrity 绕过残留。",
        "No direct runtime or converging heuristic signal surfaced in the current app process." to "当前应用进程中未发现直接运行时信号或相互印证的启发式信号。",
        "The FD trap stayed clean and the native runtime snapshot did not expose TMP_PATH, linker, maps, heap, thread, or descriptor traces associated with Zygisk-style injection." to "FD 陷阱及原生运行时快照未发现与 Zygisk 类注入有关的 TMP_PATH、链接器、内存映射、堆、线程或描述符痕迹。",
        "Only heuristic residue surfaced, so this result should be read together with Memory and Mount before treating it as a confirmed Zygisk runtime." to "仅发现启发式残留，应结合内存和挂载检测，不能直接认定 Zygisk 运行时存在。",
        "FD trap or direct runtime probes exposed evidence consistent with TMP_PATH leakage, specialization tampering, namespace bypass, linker redirection, ptrace attachment, or libc-hook side effects." to "FD 陷阱或直接运行时探针发现了 TMP_PATH 泄露、进程特化篡改、命名空间绕过、链接器重定向、ptrace 附加或 libc Hook 的相关证据。",
        "One or more major scan paths were unavailable, so this card cannot treat the absence of hits as a clean runtime result." to "一个或多个重要扫描路径不可用，不能将没有命中视为运行时完全正常。",
        "No common Play Integrity Fix residue surfaced from the current property catalog or runtime trace heuristics." to "属性目录和运行时痕迹探针未发现常见 Play Integrity Fix 残留。",
        "Direct spoof properties or runtime traces suggest active or recently used Play Integrity bypass infrastructure." to "直接伪装属性或运行时痕迹提示 Play Integrity 绕过组件正在使用或近期曾使用。",
        "Only lower-confidence residue or cross-source drift surfaced. This can reflect disabled leftovers, partial cleanup, or source disagreement." to "仅发现可信度较低的残留或多来源差异，可能是禁用后的痕迹、清理不完整或来源不一致。",
        "Observed key properties matched conservative production expectations across multiple read paths." to "关键属性在多条读取路径上的结果与常规量产设备预期一致。",
        "Key properties, framework constants, native libc reads, raw boot parameters, and property-area layout stayed aligned." to "关键属性、框架常量、原生 libc 读取值、原始启动参数及属性区布局相互一致。",
        "Cross-source drift, cross-property drift, or raw property-area residue suggests a review-worthy build or boot context, even if not every warning means active compromise." to "多来源或多属性差异、原始属性区残留提示构建或启动环境需要核查，但警告不一定代表正在被篡改。",
        "The current app context contains direct emulator, AVF guest, device-node, classpath, UID, or runtime-service evidence." to "当前应用环境中发现模拟器、AVF 客体、设备节点、类路径、UID 或运行时服务的直接证据。",
        "The app is not conclusively inside a guest, but translation, renderer, classpath drift, consistency drift, or honeypot anomalies still require review." to "无法确定应用是否位于虚拟客体内，但转译层、渲染器、类路径、一致性或蜜罐探针异常仍需核查。",
        "Known virtualization host apps are present on the device, but current process probes did not confirm guest execution." to "设备中存在已知虚拟化宿主应用，但当前进程探针未确认客体运行。",
        "No hard kernel naming marker surfaced from fallback identity reads, but native-only /proc checks were unavailable on this build." to "备用内核标识读取未发现明确标记，但此构建的原生 /proc 检查不可用。",
        "Kernel identity, boot parameters, and behavior heuristics stayed within expected bounds." to "内核标识、启动参数和行为探针均在预期范围内。",
        "Kernel behavior heuristics surfaced review-worthy signals, but they are weaker than direct naming or boot parameter anomalies." to "内核行为探针发现需要核查的信号，其可信度低于直接标识或启动参数异常。",
        "The Unicode path-bypass probe suggests CVE-2024-43093 is not fully patched, but this is informational context rather than a kernel-compromise signal." to "Unicode 路径绕过探针提示 CVE-2024-43093 可能未完全修复；这仅是参考信息，并不直接证明内核被篡改。",
        "The Unicode path-bypass probe could not determine whether CVE-2024-43093 is fully patched on this device." to "Unicode 路径绕过探针无法确定此设备是否已完整修复 CVE-2024-43093。",
        "No native root indicator surfaced from available probes, but one or more direct, cgroup, isolated-process, or package-visibility evidence paths had reduced coverage." to "可用探针未发现原生 Root 指标，但直接探针、cgroup、隔离进程或应用可见性检查存在覆盖不足。",
        "No common KernelSU, APatch, Magisk, SUSFS, or cgroup-leak traces surfaced from the current probe set." to "当前探针未发现常见 KernelSU、APatch、Magisk、SUSFS 或 cgroup 泄露痕迹。",
        "Native coverage was unavailable on this build, so only Java-side probes were used." to "当前构建缺少原生检测，因此仅使用 Java 侧探针。",
        "Available probes were clean, but package visibility, property-area, or native symbol coverage was incomplete on this build." to "可用探针未发现异常，但应用可见性、属性区或原生符号检测覆盖不完整。",
        // Second-pass Kotlin mapper strings used by Home detector cards.
        "Bootloader scan failed." to "引导加载程序扫描失败。",
        "Attested deviceLocked" to "认证的 deviceLocked",
        "Attested hash vs vbmeta digest" to "认证哈希与 vbmeta 摘要",
        "Verified boot coherence" to "验证启动一致性",
        "Property source mismatch" to "属性来源不一致",
        "Widevine credential" to "Widevine 凭据",
        "Widevine Java/native parity" to "Widevine Java/原生一致性",
        "Key attestation" to "密钥认证",
        "Package visibility looked restricted, so clean package results may under-report ROM apps." to "应用可见性看起来受到限制，因此未发现异常的应用包结果可能漏报 ROM 相关应用。",
        "Custom ROM scan failed." to "第三方 ROM 扫描失败。",
        "No custom ROM signature surfaced from available probes, but package visibility, property-area, or native symbol coverage was incomplete." to "可用探针未发现第三方 ROM 特征，但应用可见性、属性区或原生符号检测覆盖不完整。",
        "Tracked property area, serial, and residual value checks were clean" to "属性区、序列号与残留值检查未发现异常",
        "tracked property names" to "个已跟踪属性名",
        "PackageManager, createPackageContext + ZipFile, open APK descriptors, storage mirrors, loopback, IPC, accessibility, and native package-path probes are collecting local evidence." to "正在通过 PackageManager、createPackageContext + ZipFile、APK 文件描述符、存储镜像、回环连接、IPC、无障碍及原生应用路径探针收集本地证据。",
        "Dangerous app scan failed before inventory could be built." to "在完成应用清单前，风险应用扫描已失败。",
        "Multiple fixed shared-storage baseline paths returned EACCES/EPERM under stat(). This suggests shared user gid or related zygote storage groups may have been restricted." to "多个固定共享存储基线路径在 stat() 检查时返回 EACCES/EPERM，可能表示共享用户 GID 或相关 Zygote 存储组受到限制。",
        "createPackageContext + ZipFile, open APK descriptor, and storage-side probes still ran, but a clean result may under-report installed tools when PackageManager visibility is scoped." to "createPackageContext + ZipFile、APK 文件描述符与存储侧探针仍已运行，但当 PackageManager 可见性受限时，正常结果可能漏报已安装工具。",
        "PackageManager, createPackageContext + ZipFile, open APK descriptors, storage, loopback, IPC, accessibility, and native package-path probes did not surface known high-risk tools." to "PackageManager、createPackageContext + ZipFile、APK 文件描述符、存储、回环连接、IPC、无障碍和原生应用路径探针均未发现已知高风险工具。",
        "These packages were detected by direct corroboration probes but hidden from PackageManager inventory. This is the only Dangerous Apps path that stays red." to "这些应用包被直接交叉探针发现，但未出现在 PackageManager 清单中；这是风险应用检测中唯一保持红色告警的情况。",
        "Probe families" to "探针类别",
        "Full inventory access" to "完整应用清单访问",
        "Scoped inventory access" to "受限应用清单访问",
        "Device info collection failed." to "设备信息收集失败。",
        "Kernel naming, boot parameter, pointer-exposure, and Unicode path-bypass heuristics are collecting local evidence." to "正在收集内核命名、启动参数、指针暴露和 Unicode 路径绕过等本地证据。",
        "Kernel Check failed before evidence could be assembled." to "在完成证据整理前，内核检测已失败。",
        "The kernel identity read through uname disagrees with the identity exported through /proc or with the value captured when this app's runtime started, which points at active kernel version spoofing." to "通过 uname 读取的内核标识与 /proc 导出值或应用启动时记录值不一致，这可能表明存在主动的内核版本伪装。",
        "Kernel identity text or boot-time native checks surfaced markers commonly seen on modified or community-built kernels." to "内核标识文本或启动阶段原生检查发现了常见于修改版或社区内核的标记。",
        "Kernel naming" to "内核命名",
        "No hard kernel naming or boot-time anomaly surfaced." to "未发现明确的内核命名或启动阶段异常。",
        "No hard kernel naming anomaly surfaced from fallback identity reads, but native boot/cmdline checks were unavailable." to "备用标识读取未发现明确的内核命名异常，但原生启动参数检查不可用。",
        "Gathering local kernel evidence." to "正在收集本地内核证据。",
        "Kernel Check scan failed." to "内核检测扫描失败。",
        "The kernel identity differs between the sources that export it, so the version this device reports to apps is being rewritten rather than simply being unusual." to "不同来源导出的内核标识不一致，说明设备向应用报告的版本可能被重写，而不只是版本本身较为特殊。",
        "Modified or community-built kernels can change trust posture, boot state, and device integrity behavior." to "修改版或社区内核可能改变设备的信任状态、启动状态与完整性行为。",
        "These heuristics do not prove malicious compromise, but they do indicate the kernel differs from conservative stock expectations." to "这些启发式信号不能证明设备遭到恶意入侵，但说明内核与保守的原厂预期存在差异。",
        "Play Integrity, banking apps, or DRM-sensitive apps may react differently on such kernels." to "Play Integrity、银行应用或 DRM 敏感应用在此类内核上可能表现不同。",
        "Behavior-level signals are weaker than direct naming or boot parameter hits and should be interpreted with device context." to "行为级信号弱于直接的内核命名或启动参数命中，应结合设备实际环境判断。",
        "A partial CVE patch or exposed kernel pointers can reflect aftermarket hardening gaps rather than active compromise." to "CVE 修复不完整或内核指针暴露可能反映第三方内核加固不足，而不一定表示正在被攻击。",
        "The CVE-2024-43093 probe suggests the path-filter fix is missing or incomplete, but this remains informational context rather than a root or tamper verdict." to "CVE-2024-43093 探针提示路径过滤修复可能缺失或不完整，但这只是参考信息，不应直接判定 Root 或篡改。",
        "This signal is useful for hardening posture, but it should not elevate the entire kernel card to warning on its own." to "该信号可用于评估加固状态，但不应单独把整个内核卡片提升为警告。",
        "The CVE-2024-43093 probe was inconclusive, so this card cannot claim the path-filter fix is present." to "CVE-2024-43093 探针结果无法确定，因此不能认定路径过滤修复已经存在。",
        "An inconclusive result is weaker than a warning and can happen when direct Android/data listing behavior does not allow a clean bypass experiment." to "无法确定的结果弱于警告；当 Android/data 的直接列目录行为不适合进行稳定绕过实验时可能出现这种情况。",
        "No hard kernel naming marker surfaced from fallback identity reads, but native-only /proc checks were unavailable." to "备用内核标识读取未发现明确命名标记，但仅原生可用的 /proc 检查不可用。",
        "This support-only result has reduced coverage and should not be read as a strong clean kernel verdict." to "该结果仅用于辅助判断且覆盖受限，不应视为内核完全正常的强结论。",
        "No suspicious naming, boot parameter, or behavior signal surfaced." to "未发现可疑的内核命名、启动参数或行为信号。",
        "This remains heuristic evidence rather than proof of a fully stock device." to "这仍属于启发式证据，不能证明设备完全处于原厂状态。",
        "Keyword families checked" to "已检查关键词组",
        "Cmdline rules checked" to "已检查启动参数规则",
        "Identity sources" to "标识来源",
        "Unicode ignorable codepoints still bypass the path filter." to "Unicode 可忽略码点仍可绕过路径过滤。",
        "ZWC is blocked, but at least one other ignorable codepoint still bypasses the path filter." to "ZWC 已被阻止，但至少还有一个其他可忽略码点能够绕过路径过滤。",
        "The tested bypass characters were blocked." to "测试的绕过字符均已被阻止。",
        "The probe could not determine a stable patch state." to "探针无法确定稳定的修复状态。",
        "kptr_restrict appears disabled." to "kptr_restrict 似乎已禁用。",
        "Kernel addresses remained hidden during the native probe." to "原生探针运行期间内核地址保持隐藏。",
        "Native /proc coverage was unavailable, so pointer exposure could not be verified." to "原生 /proc 检查不可用，因此无法验证内核指针暴露情况。",
        "Single source" to "单一来源",
        "Runtime probes" to "运行时探针",
        "Binder probes" to "Binder 探针",
        "Class loading, ClassLoader chains, XposedBridge fields, callbacks, package metadata, stack traces, Binder bridges, zygote permission GID audits, runtime artifacts, logcat leaks, and LSPosed-specific native traces are collecting local evidence." to "正在收集类加载、ClassLoader 链、XposedBridge 字段、回调、应用元数据、堆栈、Binder 桥、Zygote 权限 GID、运行时痕迹、logcat 泄露和 LSPosed 原生痕迹等本地证据。",
        "LSPosed detection failed before evidence could be assembled." to "在完成证据整理前，LSPosed 检测已失败。",
        "Binder bridge replies, loaded Xposed classes, XposedBridge fields, callback handlers, runtime artifacts, logcat leaks, zygote permission GID mismatches, dirty SELinux policy rules, stack trace signatures, or native LSPosed keywords point to active hook-framework presence rather than passive install residue." to "Binder 桥响应、已加载的 Xposed 类、XposedBridge 字段、回调处理器、运行时痕迹、logcat 泄露、Zygote 权限 GID 不一致、异常 SELinux 策略、堆栈特征或 LSPosed 原生关键词，更倾向于说明 Hook 框架正在活动，而非仅有安装残留。",
        "Installed managers, deep ClassLoader chains, environment residue, dirty SELinux policy drift, or pattern-only logcat traces were found, but the current process did not expose enough stronger runtime evidence to treat the framework as confirmed active here." to "发现管理器应用、较深的 ClassLoader 链、环境残留、SELinux 策略漂移或仅模式匹配的 logcat 痕迹，但当前进程没有暴露足够强的运行时证据，不能确认框架正在此进程中活动。",
        "This LSPosed evidence slice was unavailable or scoped, so it is not treated as clean." to "该 LSPosed 证据范围不可用或受限，因此不能视为正常。",
        "No signal surfaced in this LSPosed evidence slice." to "当前 LSPosed 证据范围内未发现信号。",
        "Gathering class, ClassLoader, Binder, runtime-artifact, logcat, package, SELinux policy, and native runtime evidence." to "正在收集类、ClassLoader、Binder、运行时痕迹、logcat、应用包、SELinux 策略和原生运行时证据。",
        "LSPosed scan failed." to "LSPosed 扫描失败。",
        "Loaded Xposed classes, bridge fields, Binder bridge responses, runtime artifacts, logcat leaks, dirty SELinux policy rules, and native LSPosed keywords are stronger evidence than package residue because they touch the current process, live policy, or system services directly." to "已加载的 Xposed 类、桥接字段、Binder 桥响应、运行时痕迹、logcat 泄露、异常 SELinux 策略和 LSPosed 原生关键词，比单纯应用包残留更强，因为它们直接涉及当前进程、实时策略或系统服务。",
        "This card still observes only a narrow runtime slice. Read it together with Memory, Native Root, Mount, and System Properties when the setup is actively hiding itself." to "此卡片仍只观察有限的运行时范围；若环境存在主动隐藏，请结合内存、原生 Root、挂载和系统属性检测一起判断。",
        "Manager packages, Xposed module meta-data, or dirty SELinux policy drift show framework or root-policy residue, but they do not prove the current process is hooked right now." to "管理器应用、Xposed 模块元数据或 SELinux 策略漂移可以说明框架或 Root 策略残留，但不能证明当前进程此刻正被 Hook。",
        "Hardened setups can avoid exposing direct stack or class evidence in the current app, so yellow-only results still deserve correlation with other detector cards." to "经过加固的环境可能不会向当前应用暴露直接的堆栈或类证据，因此仅黄色结果仍应与其他检测卡片交叉核对。",
        "No LSPosed/Xposed signal surfaced from available probes, but one or more runtime evidence paths were unavailable." to "可用探针未发现 LSPosed/Xposed 信号，但一个或多个运行时证据路径不可用。",
        "This support-only result lowers confidence only for the probes that actually ran." to "该辅助结果只能降低对已实际运行探针所覆盖风险的怀疑。",
        "The current app process did not expose LSPosed/Xposed class loading, Binder bridge behavior, or LSPosed-native runtime strings." to "当前应用进程未暴露 LSPosed/Xposed 类加载、Binder 桥行为或 LSPosed 原生运行时字符串。",
        "A clean result lowers confidence in active LSPosed-style hooking for this process, but it does not prove the whole device is stock." to "正常结果可降低当前进程存在 LSPosed 类 Hook 的可能性，但不能证明整台设备完全原厂。",
        "Bridge field hits" to "桥接字段命中",
        "Stack hits" to "堆栈命中",
        "Callback hits" to "回调命中",
        "Logcat availability" to "Logcat 可用性",
        "Class load" to "类加载",
        "ClassLoader chain" to "ClassLoader 链",
        "XposedBridge fields" to "XposedBridge 字段",
        "Xposed meta-data" to "Xposed 元数据",
        "Stack trace" to "堆栈跟踪",
        "Hook callbacks" to "Hook 回调",
        "Binder bridge" to "Binder 桥",
        "Logcat leaks" to "Logcat 泄露",
        "Dirty sepolicy" to "异常 SELinux 策略",
        "Memory scan failed." to "内存扫描失败。",
        "Magisk mounts" to "Magisk 挂载",
        "Debug ramdisk" to "调试 ramdisk",
        "System RW" to "系统分区可写",
        "Overlay mounts" to "Overlay 挂载",
        "Loop devices" to "Loop 设备",
        "dm-verity bypass" to "dm-verity 绕过",
        "Overlayfs support" to "Overlayfs 支持",
        "Tmpfs anomaly" to "Tmpfs 异常",
        "Namespace access" to "命名空间访问",
        "Mount ID loophole" to "挂载 ID 漏洞",
        "Bind mount root" to "Root 绑定挂载",
        "Mount scan failed." to "挂载扫描失败。",
        "Native Root scan failed." to "原生 Root 扫描失败。",
        "Direct native hits are stronger than plain package or property signals because they come from syscall behavior, runtime processes, cgroup visibility mismatches, or corroborated runtime residue paths." to "直接原生命中比单纯的应用包或属性信号更强，因为它们来自系统调用行为、运行时进程、cgroup 可见性不一致或相互印证的运行时残留路径。",
        "Isolated-process mount drift, manager manifest fingerprints, kernel strings, property residue, or cgroup leakage can indicate native-root history or selective runtime hiding, but they are weaker than direct syscall-side probes." to "隔离进程挂载差异、管理器清单特征、内核字符串、属性残留或 cgroup 泄露可能表明存在原生 Root 历史或选择性隐藏，但弱于直接的系统调用侧探针。",
        "No native root indicator surfaced from available probes, but one or more support-only evidence paths were unavailable or scoped." to "可用探针未发现原生 Root 指标，但一个或多个辅助证据路径不可用或受限。",
        "Kernel hits" to "内核命中",
        "Play Integrity Fix scan failed." to "Play Integrity Fix 扫描失败。",
        "getprop hits" to "getprop 命中",
        "JVM fallback" to "JVM 备用读取",
        "Native libc props" to "原生 libc 属性",
        "repeatability failed" to "重复性检查失败",
        "Dirty sepolicy rule: MSD" to "异常 SELinux 策略规则：MSD",
        "Dirty sepolicy rule: Droidspaces" to "异常 SELinux 策略规则：Droidspaces",
        "below minimum" to "低于最低要求",
        "meets minimum" to "达到最低要求",
        "Readable auditd event logs exposed the same nonce-tagged controlled AVC denial seen by the direct libselinux callback probe." to "可读取的 auditd 事件日志暴露了与 libselinux 直接回调探针相同、带 nonce 标记的受控 AVC 拒绝事件。",
        "Readable AVC denials referenced su/magisk/ksud-related actor strings in comm, exe, path, or name fields." to "可读取的 AVC 拒绝日志在 comm、exe、path 或 name 字段中出现了 su/magisk/ksud 相关主体字符串。",
        "rewrite markers" to "重写标记",
        "su-related actor" to "SU 相关主体",
        "Readable auditpatch residue" to "可读取的 auditpatch 残留",
        "did not expose" to "未暴露",
        "SELinux paradox: permission denied can prove enforcing mode." to "SELinux 的“悖论”是：权限被拒绝反而可以证明处于 Enforcing 模式。",
        "Enforcing mode blocks disallowed actions instead of only logging them." to "Enforcing 模式会阻止不允许的操作，而不只是记录日志。",
        "Production Android devices are expected to run enforcing SELinux." to "量产 Android 设备通常应运行 Enforcing SELinux。",
        "app_zygote can query SELinux context validity through selinux_check_context, which ultimately writes to /sys/fs/selinux/context." to "app_zygote 可通过 selinux_check_context 查询 SELinux 上下文有效性，该过程最终会写入 /sys/fs/selinux/context。",
        "A dedicated app_zygote carrier can also probe privileged context materialization by writing candidate labels to /proc/self/attr/current and classifying non-EINVAL outcomes." to "专用 app_zygote 载体还可以通过向 /proc/self/attr/current 写入候选标签并分析非 EINVAL 结果，探测特权上下文是否可被实例化。",
        "The policyload/access seqno oracle must be captured inside zygotePreloadName; the isolated child may lose app_zygote SELinuxfs access and should downgrade missing coverage to info." to "policyload/access 的序列号探针必须在 zygotePreloadName 内捕获；隔离子进程可能失去 app_zygote 的 SELinuxfs 访问能力，此时缺失覆盖应降级为信息提示。",
        "Audit or log surfaces can be rewritten in user space, so missing suspicious tcontext values is not always proof." to "审计或日志界面可能在用户空间被重写，因此没有出现可疑 tcontext 值并不总能作为证明。",
        "Readable AVC denial lines should be treated as audit-surface leakage, not as direct proof of a root process." to "可读取的 AVC 拒绝行应视为审计界面泄露，而不是 Root 进程存在的直接证据。",
        "comm, exe, path, and name fields inside AVC logs are supporting hints, not standalone proof of a live su daemon." to "AVC 日志中的 comm、exe、path 和 name 字段仅是辅助线索，不能单独证明存在正在运行的 su 守护进程。",
        "Carrier state=untrusted" to "载体状态=不受信任",
        "Carrier state=failed" to "载体状态=失败",
        "SU scan failed." to "SU 扫描失败。",
        "System Properties scan failed." to "系统属性扫描失败。",
        "Build cluster" to "构建特征组",
        "QEMU guest properties" to "QEMU 客体属性",
        "qemud service" to "qemud 服务",
        "AVF runtime" to "AVF 运行环境",
        "Emulator device node" to "模拟器设备节点",
        "Host dex path" to "宿主 DEX 路径",
        "Classpath/source mismatch" to "类路径/来源不一致",
        "Current package missing from UID" to "当前应用包未出现在 UID 中",
        "Cross-process path drift" to "跨进程路径差异",
        "Native timing trap" to "原生时序陷阱",
        "ASM counter trap" to "ASM 计数器陷阱",
        "Sacrificial openat2" to "牺牲进程 openat2 探针",
        "Parallel Space" to "平行空间",
        "No direct virtualization signal surfaced from the available probes, but one or more native, preload, helper-process, graphics, namespace, or syscall paths were unavailable." to "可用探针未发现直接虚拟化信号，但一个或多个原生、预加载、辅助进程、图形、命名空间或系统调用路径不可用。",
        "Virtualization scan failed." to "虚拟化扫描失败。",
        "Mountinfo lines" to "mountinfo 行",
        "Zygisk detection failed." to "Zygisk 检测失败。",
        "This is stronger than package residue because it touches live loader behavior, specialization side effects, or process runtime state directly." to "这比应用包残留更强，因为它直接涉及实时加载器行为、进程特化副作用或进程运行状态。",
        "No positive runtime signal surfaced in the current process." to "当前进程未发现明确的运行时阳性信号。",
        "No positive signal surfaced, but a major scan path was unavailable so the result is support-only." to "未发现阳性信号，但有主要扫描路径不可用，因此该结果仅供辅助判断。",
        "Grant self-domain" to "授权自域",
        "Grant isolated-domain" to "授权隔离域",
        "Grant handle" to "授权句柄",
        "Grant caller binding" to "授权调用方绑定",
        "key visibility" to "密钥可见性",
        "mount" to "挂载",
        "DRM consistency" to "DRM 一致性",
        "boot state" to "启动状态",
        "startup" to "启动阶段",
        "native" to "原生",
        "property" to "属性",
        "virtualization" to "虚拟化",

        // Remaining technical labels shown on expanded Home cards.
        "native /proc" to "原生 /proc",
        "fallback file reads" to "备用文件读取",
        "Startup preload:" to "启动预加载：",
        "Build.TYPE <> fingerprint tail" to "Build.TYPE 与设备指纹尾部不一致",
        "prop_area hole: u:object_r:shell_prop:s0" to "属性区空洞：u:object_r:shell_prop:s0",
        "prop_area hole:" to "属性区空洞：",
        "Android Virtualization Framework: https://source.android.com/docs/core/virtualization" to "Android 虚拟化框架：https://source.android.com/docs/core/virtualization",
        "Android Emulator: https://developer.android.com/studio/run/emulator" to "Android 模拟器：https://developer.android.com/studio/run/emulator",
        "AOSP property_contexts: https://android.googlesource.com/platform/system/sepolicy/+/refs/heads/main/private/property_contexts" to "AOSP property_contexts：https://android.googlesource.com/platform/system/sepolicy/+/refs/heads/main/private/property_contexts",

        // Home card component labels outside the model mappers.
        "Build signals" to "构建信号",
        "Runtime signals" to "运行时信号",
        "Framework traces" to "框架痕迹",
        "No package hits" to "未发现应用包命中",
        "Runtime checks" to "运行时检查",
        "Mappings and FD-backed code" to "内存映射与 FD 支持代码",
        "Runtime mounts" to "运行时挂载",
        "Namespace and consistency" to "命名空间与一致性",
        "Kernel traces" to "内核痕迹",
        "Spoof properties" to "伪装属性",
        "Runtime traces" to "运行时痕迹",
        "Native context" to "原生上下文",
        "Host Apps" to "宿主应用",
        "fd trap" to "FD 陷阱",

        // TEE report headlines and concise explanations.
        "Attestation aligned; local probes need review" to "认证结果一致，但本地探针需要核查",
        "Local TEE attestation checks aligned" to "本地 TEE 认证检查一致",
        "Policy-backed attestation anomalies were detected" to "检测到受策略保护的认证异常",
        "Policy-backed attestation evidence needs review" to "受策略保护的认证证据需要核查",
        "Hardware-backed local verification was not established" to "未建立硬件支持的本地验证",
        "Local verification stayed inconclusive" to "本地验证结果仍无法确定",
        "Attestation, trust path, and revocation checks line up." to "认证、信任路径和吊销检查结果一致。",
        "Attestation and trust-path checks still aligned." to "认证与信任路径检查仍保持一致。",
        "Multiple hard anomaly indicators were raised." to "发现多项高可信异常指标。",
        "Policy-backed review signals suggest further review." to "受策略保护的检查发现需要进一步核查的信号。",
        "Local verification could not establish hardware-backed trust." to "本地验证无法建立硬件支持的信任。",
        "Signals were mixed and did not converge on a stable local result." to "信号相互矛盾，无法得到稳定的本地结论。",
        "Collecting local attestation and keystore evidence." to "正在收集本地认证和密钥库证据。",
        "Local trust path pending" to "本地信任路径检查中",
        "Local trust path unavailable" to "本地信任路径不可用",
        "Local TEE verification failed" to "本地 TEE 验证失败",
        "Aligned • local review" to "结果一致 · 需本地核查",
        "Checks aligned" to "检查结果一致",
        "No hardware trust" to "无法建立硬件信任",
        "Mixed signals" to "信号不一致",
        "Scanning" to "扫描中",
        "Aligned + review" to "结果一致，仍需核查",
        "Aligned" to "结果一致",
        "Tampered" to "疑似被篡改",
        "Broken" to "验证失败",
        "Mixed" to "结果不一致",
        "Verdict" to "结论",
        "Score" to "评分",
        "Details" to "详情",
        "Checks" to "检查项目",
        "Collection failure" to "证据收集失败",
        "Attestation" to "设备认证",
        "Root fingerprint" to "根证书指纹",
        "Patch levels" to "补丁级别",
        "Key properties" to "密钥属性",
        "User auth" to "用户认证",
        "Application" to "应用信息",
        "Grant self-domain certificate chain diverged; open TEE details for stage diagnostics." to "自域授权的证书链不一致；请打开 TEE 详情查看各阶段诊断。",
        "Grant self-domain key visibility diverged; open TEE details for stage diagnostics." to "自域授权的密钥可见性不一致；请打开 TEE 详情查看各阶段诊断。",
        "Grant isolated-domain certificate chain diverged; open TEE details for stage diagnostics." to "隔离域授权的证书链不一致；请打开 TEE 详情查看各阶段诊断。",
        "Grant isolated-domain key visibility diverged; open TEE details for stage diagnostics." to "隔离域授权的密钥可见性不一致；请打开 TEE 详情查看各阶段诊断。",
        "Grant isolated-domain runtime crash; open TEE details for stage diagnostics." to "隔离域授权运行时崩溃；请打开 TEE 详情查看各阶段诊断。",
        "Grant handle caller binding failed; open TEE details for stage diagnostics." to "授权句柄的调用方绑定失败；请打开 TEE 详情查看各阶段诊断。",
        "Built-in revocation snapshot is active; online refresh is disabled in Settings." to "内置吊销快照正在使用；设置中已关闭在线刷新。",
        "Online revocation data refreshed successfully." to "在线吊销数据刷新成功。",
        "Online CRL refresh failed; built-in revocation snapshot was used." to "在线 CRL 刷新失败，已使用内置吊销快照。",

        // Common expanded-card labels. Keep implementation identifiers and raw values intact.
        "Boot consistency" to "启动状态一致性",
        "Boot parameters" to "启动参数",
        "Boot properties" to "启动属性",
        "Boot state" to "启动状态",
        "Boot raw" to "原始启动参数",
        "Verified boot" to "验证启动",
        "Certificate trust" to "证书信任",
        "Attestation chain" to "认证证书链",
        "Attestation tier" to "认证安全级别",
        "Attested boot state" to "认证的启动状态",
        "Lock state" to "锁定状态",
        "Properties checked" to "已检查属性",
        "Properties observed" to "已观察属性",
        "Rules checked" to "已检查规则",
        "Rules observed" to "已观察规则",
        "Cross-checks" to "交叉核验",
        "Cross-check rules" to "交叉核验规则",
        "Cross-source consistency" to "跨来源一致性",
        "Source mismatches" to "来源不一致",
        "Source consistency" to "来源一致性",
        "Raw boot hits" to "原始启动参数命中",
        "Native hits" to "原生检测命中",
        "Runtime hits" to "运行时命中",
        "Danger findings" to "危险发现",
        "Review findings" to "待核查发现",
        "Hard findings" to "高可信发现",
        "Info findings" to "参考信息",
        "Path hits" to "路径命中",
        "Paths checked" to "已检查路径",
        "Package visibility" to "应用可见性",
        "Packages checked" to "已检查应用",
        "Package catalog" to "应用目录",
        "Visible packages" to "可见应用",
        "Manager packages" to "管理器应用",
        "Module apps" to "模块应用",
        "Class hits" to "类命中",
        "ClassLoader hits" to "类加载器命中",
        "Binder hits" to "Binder 命中",
        "Logcat hits" to "日志命中",
        "Runtime artifacts" to "运行时痕迹",
        "Runtime artifact hits" to "运行时痕迹命中",
        "Runtime artifacts availability" to "运行时痕迹检查状态",
        "Dirty policy hits" to "策略异常命中",
        "Dirty policy availability" to "策略检查状态",
        "Native maps" to "原生内存映射",
        "Native heap" to "原生堆",
        "Native library" to "原生库",
        "Native traces" to "原生痕迹",
        "Native symbols" to "原生符号",
        "Native probes" to "原生探针",
        "Modified functions" to "被修改的函数",
        "Function hooks" to "函数 Hook",
        "Loader visibility" to "加载器可见性",
        "Signal handlers" to "信号处理器",
        "Threads and FDs" to "线程与文件描述符",
        "FD entries" to "文件描述符条目",
        "FD trap" to "FD 陷阱",
        "Cross-process FD trap" to "跨进程 FD 陷阱",
        "Mount namespace" to "挂载命名空间",
        "Mount entries" to "挂载条目",
        "Mountinfo entries" to "mountinfo 条目",
        "Mounts readable" to "挂载信息可读取",
        "Mountinfo readable" to "mountinfo 可读取",
        "Mount consistency" to "挂载一致性",
        "Cross-process mount views" to "跨进程挂载视图",
        "Isolated process mounts" to "隔离进程挂载",
        "Isolated mount drift" to "隔离进程挂载差异",
        "Mount drift hits" to "挂载差异命中",
        "Root artifacts" to "Root 痕迹",
        "Root processes" to "Root 进程",
        "Root daemons" to "Root 守护进程",
        "SU binaries" to "SU 可执行文件",
        "SU paths checked" to "已检查 SU 路径",
        "Proc contexts checked" to "已检查进程上下文",
        "Proc reads denied" to "进程信息读取被拒",
        "Self context" to "当前进程上下文",
        "Kernel identity" to "内核标识",
        "Kernel behavior" to "内核行为",
        "Kernel symbols" to "内核符号",
        "Kernel modules" to "内核模块",
        "Kernel sources" to "内核信息来源",
        "CVE patch state" to "CVE 修复状态",
        "Property residue" to "属性残留",
        "Property hits" to "属性命中",
        "Property catalog" to "属性目录",
        "Reflection hits" to "反射读取命中",
        "JVM hits" to "JVM 读取命中",
        "Native prop hits" to "原生属性命中",
        "Prop area anomalies" to "属性区异常",
        "Prop area holes" to "属性区空洞",
        "Full property audit" to "完整属性审计",
        "Transient skips" to "跳过的瞬时值",
        "Mismatched fields" to "不一致字段",
        "TEE Detailed Export" to "TEE 详细导出",
        "System properties" to "系统属性",
        "System filesystem type" to "系统文件系统类型",
        "Security classes" to "安全类别",
        "Permissive domains" to "宽松域",
        "SELinux policy" to "SELinux 策略",
        "Policy analysis" to "策略分析",
        "Policy version" to "策略版本",
        "Process context" to "进程上下文",
        "AVC side-channel" to "AVC 旁路信息",
        "Audit integrity" to "审计完整性",
        "Zygote permissions" to "Zygote 权限",
        "HMA mismatch" to "HMA 可见性不一致",
        "Environment hits" to "环境命中",
        "Translation hits" to "转译层命中",
        "Consistency hits" to "一致性检查命中",
        "Honeypot hits" to "蜜罐探针命中",
        "UID identity hits" to "UID 身份命中",
        "EGL renderer" to "EGL 渲染器",
        "Graphics renderer" to "图形渲染器",
        "Device IDs" to "设备标识",
        "Build profile" to "构建配置",
        "Properties and build" to "属性与构建信息",
        "Packages and modules" to "应用包与模块",
        "Binder and services" to "Binder 与服务",
        "Runtime markers" to "运行时痕迹",
    )

    private val countPatterns = listOf(
        Regex("""^(\d+) policy anomaly$""") to { m: MatchResult -> "${m.groupValues[1]} 项策略异常" },
        Regex("""^(\d+) policy review$""") to { m: MatchResult -> "${m.groupValues[1]} 项策略待核查" },
        Regex("""^(\d+) high-risk memory signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个高风险内存信号" },
        Regex("""^(\d+) high-risk LSPosed signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个高风险 LSPosed 信号" },
        Regex("""^(\d+) LSPosed residue signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个 LSPosed 残留信号" },
        Regex("""^(\d+) high-risk property or coherence signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个高风险属性或一致性信号" },
        Regex("""^(\d+) high-confidence residue signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个高可信残留信号" },
        Regex("""^(\d+) suspicious kernel signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个可疑内核信号" },
        Regex("""^(\d+) risky package\(s\) surfaced$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个风险应用包" },
        Regex("""^(\d+) direct virtualization signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个直接虚拟化信号" },
        Regex("""^(\d+) corroborating host app\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个相关宿主应用" },
        Regex("""^(\d+) runtime root signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个运行时 Root 信号" },
        Regex("""^(\d+) direct runtime signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个直接运行时信号" },
        Regex("""^(\d+) heuristic probes converged$""") to { m: MatchResult -> "${m.groupValues[1]} 项启发式探针指向同一异常" },
        Regex("""^(\d+) critical DRM consistency signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个严重 DRM 一致性信号" },
        Regex("""^(\d+) critical boot integrity signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个严重启动完整性信号" },
        Regex("""^(\d+) critical mount signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个严重挂载信号" },
        Regex("""^(\d+) critical startup signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个严重启动阶段信号" },
        Regex("""^(\d+) DRM consistency signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个 DRM 一致性信号待核查" },
        Regex("""^(\d+) boot state signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个启动状态信号待核查" },
        Regex("""^(\d+) mount signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个挂载信号待核查" },
        Regex("""^(\d+) startup signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个启动阶段信号待核查" },
        Regex("""^(\d+) native signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个原生检测信号待核查" },
        Regex("""^(\d+) property signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个属性信号待核查" },
        Regex("""^(\d+) virtualization signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个虚拟化信号待核查" },
        Regex("""^(\d+) signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个信号待核查" },
        Regex("""^(\d+) strong · (\d+) heuristic · (\d+) signal\(s\)$""") to { m: MatchResult ->
            "${m.groupValues[1]} 个强信号 · ${m.groupValues[2]} 个启发式信号 · ${m.groupValues[3]} 个总信号"
        },
        Regex("""^(\d+) mounts · (\d+) mountinfo · (\d+) map lines$""") to { m: MatchResult ->
            "${m.groupValues[1]} 个挂载条目 · ${m.groupValues[2]} 个 mountinfo 条目 · ${m.groupValues[3]} 行内存映射"
        },
        Regex("""^(\d+) props · (\d+) hits · (\d+) mismatch · (\d+) traces$""") to { m: MatchResult ->
            "${m.groupValues[1]} 项属性 · ${m.groupValues[2]} 个命中 · ${m.groupValues[3]} 处不一致 · ${m.groupValues[4]} 条痕迹"
        },
        Regex("""^(\d+) rules · (\d+) info · (\d+) native · (\d+) Build(?: · (\d+) prop-area hole\(s\))?$""") to { m: MatchResult ->
            "${m.groupValues[1]} 条规则 · ${m.groupValues[2]} 项信息 · ${m.groupValues[3]} 个原生命中 · ${m.groupValues[4]} 项构建信号" +
                m.groupValues[5].takeIf { it.isNotEmpty() }?.let { " · $it 个属性区域缺口" }.orEmpty()
        },
        Regex("""^(\d+) env · (\d+) translation · (\d+) runtime((?: · \d+ (?:dex|uid|trap hit\(s\)|host app\(s\)))*)$""") to { m: MatchResult ->
            val suffix = Regex(""" · (\d+) (dex|uid|trap hit\(s\)|host app\(s\))""")
                .replace(m.groupValues[4]) { part ->
                    val label = when (part.groupValues[2]) {
                        "dex" -> "DEX 路径"
                        "uid" -> "UID 标识"
                        "trap hit(s)" -> "陷阱命中"
                        else -> "宿主应用"
                    }
                    " · ${part.groupValues[1]} 个$label"
                }
            "${m.groupValues[1]} 个环境信号 · ${m.groupValues[2]} 个转译信号 · ${m.groupValues[3]} 个运行时信号$suffix"
        },
        Regex("""^(\d+) manager · (\d+) module · (\d+) native(?: · (\d+) policy)?$""") to { m: MatchResult ->
            "${m.groupValues[1]} 个管理器 · ${m.groupValues[2]} 个模块 · ${m.groupValues[3]} 条原生痕迹" +
                m.groupValues[4].takeIf { it.isNotEmpty() }?.let { " · $it 项策略信号" }.orEmpty()
        },
        Regex("""^(\d+) props · (\d+) mod props · (\d+) packages · (\d+) named services$""") to { m: MatchResult ->
            "${m.groupValues[1]} 项属性 · ${m.groupValues[2]} 项修改属性 · ${m.groupValues[3]} 个应用包 · ${m.groupValues[4]} 个命名服务"
        },
        Regex("""^(\d+) props · mod props unavailable · (\d+) packages · (\d+) named services$""") to { m: MatchResult ->
            "${m.groupValues[1]} 项属性 · 修改属性不可用 · ${m.groupValues[2]} 个应用包 · ${m.groupValues[3]} 个命名服务"
        },
        Regex("""^(\d+) legacy targets · (full|scoped) PM inventory(?: · (\d+) visible)?$""") to { m: MatchResult ->
            "${m.groupValues[1]} 个旧版目标 · ${if (m.groupValues[2] == "full") "完整" else "受限"}应用清单" +
                m.groupValues[3].takeIf { it.isNotEmpty() }?.let { " · $it 个可见" }.orEmpty()
        },
        Regex("""^(\d+) paths · (\d+) proc entries · (\d+) cgroup dirs · (\d+) kernel sources · (\d+) props$""") to { m: MatchResult ->
            "${m.groupValues[1]} 条路径 · ${m.groupValues[2]} 个进程条目 · ${m.groupValues[3]} 个 cgroup 目录 · ${m.groupValues[4]} 个内核来源 · ${m.groupValues[5]} 项属性"
        },
        Regex("""^(\d+) local device facts$""") to { m: MatchResult -> "${m.groupValues[1]} 项本机设备信息" },
        Regex("""^(\d+) su paths · (\d+) adb daemon paths · (native /proc scan|fallback self context)$""") to { m: MatchResult ->
            "${m.groupValues[1]} 条 su 路径 · ${m.groupValues[2]} 条 adb 守护进程路径 · ${if (m.groupValues[3] == "native /proc scan") "原生 /proc 扫描" else "备用自身上下文检查"}"
        },
        Regex("""^(\d+) keyword families · (\d+) cmdline rules · (native /proc|fallback file reads)$""") to { m: MatchResult ->
            "${m.groupValues[1]} 组关键词 · ${m.groupValues[2]} 条启动参数规则 · ${if (m.groupValues[3] == "native /proc") "原生 /proc 检查" else "备用文件读取"}"
        },
        Regex("""^7 local checks( \+ policy)?( \+ audit integrity \+ side-channel)?$""") to { m: MatchResult ->
            "7 项本地检查${if (m.groupValues[1].isNotEmpty()) " + 策略" else ""}${if (m.groupValues[2].isNotEmpty()) " + 审计完整性与旁路检查" else ""}"
        },
        Regex("""^(\d+) legacy targets$""") to { m: MatchResult -> "${m.groupValues[1]} 个旧版目标" },
        Regex("""^(\d+) legacy packages$""") to { m: MatchResult -> "${m.groupValues[1]} 个旧版应用包" },
        Regex("""^(\d+) su paths$""") to { m: MatchResult -> "已检查 ${m.groupValues[1]} 条 su 路径" },
        Regex("""^(\d+) hit\(s\)$""") to { m: MatchResult -> "${m.groupValues[1]} 个命中" },
        Regex("""^(\d+) view\(s\)$""") to { m: MatchResult -> "${m.groupValues[1]} 种视图" },
        Regex("""^(\d+) allowed$""") to { m: MatchResult -> "${m.groupValues[1]} 项允许" },
        Regex("""^(\d+) denied$""") to { m: MatchResult -> "${m.groupValues[1]} 项拒绝" },
        Regex("""^(\d+) unavailable$""") to { m: MatchResult -> "${m.groupValues[1]} 项不可用" },
        Regex("""^(\d+) critical (.+) signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个严重${translate(m.groupValues[2])}信号" },
        Regex("""^(\d+) (.+) signal\(s\) need review$""") to { m: MatchResult -> "有 ${m.groupValues[1]} 个${translate(m.groupValues[2])}信号待核查" },
        Regex("""^(\d+) (.+) signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个${translate(m.groupValues[2])}信号" },
        Regex("""^(\d+) ROM signatures$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个 ROM 特征" },
        Regex("""^(\d+) modification signal\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 个修改信号" },
        Regex("""^(\d+) native symbol trace\(s\)$""") to { m: MatchResult -> "发现 ${m.groupValues[1]} 条原生符号痕迹" },
        Regex("""^(\d+) visible$""") to { m: MatchResult -> "${m.groupValues[1]} 个可见" },
        Regex("""^(\d+) props · (\d+) certs · (\d+) cross-checks$""") to { m: MatchResult ->
            "${m.groupValues[1]} 项属性 · ${m.groupValues[2]} 张证书 · ${m.groupValues[3]} 项交叉核验"
        },
        Regex("""^(\d+) of (\d+) .+""") to { m: MatchResult -> "${m.groupValues[1]} / ${m.groupValues[2]} 项已完成" },
    )

    fun translate(text: String): String {
        exact[text]?.let { return it }
        Regex("""^Local trust path: (.+), chain (verified|failed)(.*)$""").matchEntire(text)?.let {
            val chain = if (it.groupValues[2] == "verified") "已验证" else "验证失败"
            val suffix = it.groupValues[3]
                .replace("RKP observed on an invalid local chain", "在无效本地证书链上发现 RKP")
                .replace("RKP observed, local trust needs review", "发现 RKP，本地信任需要核查")
                .replace("RKP observed", "发现 RKP")
                .replace("provisioning needs review", "证书供应状态需要核查")
            return "本地信任路径：${it.groupValues[1]}，证书链${chain}${suffix}"
        }
        if (text.endsWith(" Attestation and trust-path checks still aligned.")) {
            val detail = text.removeSuffix(" Attestation and trust-path checks still aligned.")
            return "${translate(detail)} 认证与信任路径检查仍保持一致。"
        }
        Regex("""^(.+) daemon detected$""").matchEntire(text)?.let {
            return "检测到 ${it.groupValues[1]} 守护进程"
        }
        Regex("""^(\d+) package\(s\) were visible to direct corroboration probes but absent from PackageManager inventory\.$""")
            .matchEntire(text)?.let {
                return "有 ${it.groupValues[1]} 个应用包可被直接探针发现，却未出现在 PackageManager 清单中。"
            }
        Regex("""^Matched (\d+) package\(s\) across (\d+) category\(ies\)\. All package hits stay warning-level unless HMA concealment is present\.(.*)$""")
            .matchEntire(text)?.let {
                return "在 ${it.groupValues[2]} 个类别中命中 ${it.groupValues[1]} 个应用包。除非发现 HMA 隐藏，否则应用包命中仅计为警告。${it.groupValues[3]}"
            }
        Regex("""^Listed (\d+) services\.$""").matchEntire(text)?.let {
            return "已列出 ${it.groupValues[1]} 个服务。"
        }
        Regex("""^PackageManager still exposed only (\d+) visible packages, which is unusually low and can happen under HMA-style whitelist filtering\.$""")
            .matchEntire(text)?.let {
                return "PackageManager 仍只显示 ${it.groupValues[1]} 个可见应用包，数量异常偏低，可能与 HMA 类白名单过滤有关。"
            }
        Regex("""^PackageManager reported a full inventory surface but returned only (\d+) visible packages\. That is unusually low for a modern device and can happen under HMA-style whitelist filtering\.$""")
            .matchEntire(text)?.let {
                return "PackageManager 声称提供完整应用清单，但只返回 ${it.groupValues[1]} 个可见应用包；这对现代设备来说异常偏低，可能与 HMA 类白名单过滤有关。"
            }
        Regex("""^Consistent \((\d+)\)$""").matchEntire(text)?.let {
            return "一致（${it.groupValues[1]} 个来源）"
        }
        Regex("""^No readable data surfaced for (.+)\.$""").matchEntire(text)?.let {
            return "${translate(it.groupValues[1])}未读取到可用数据。"
        }
        Regex("""^(.+) across sources$""").matchEntire(text)?.let {
            return "${translate(it.groupValues[1])}（跨来源）"
        }
        Regex("""^Result: (.*)$""").matchEntire(text)?.let {
            return "结果：${it.groupValues[1]}"
        }
        Regex("""^Probe available: (.*)$""").matchEntire(text)?.let {
            return "探针可用：${it.groupValues[1]}"
        }
        Regex("""^Distinct views: (.*)$""").matchEntire(text)?.let {
            return "不同视图数：${it.groupValues[1]}"
        }
        Regex("""^Expected views: (.*)$""").matchEntire(text)?.let {
            return "预期视图数：${it.groupValues[1]}"
        }
        Regex("""^Scanned PIDs: (.*)$""").matchEntire(text)?.let {
            return "已扫描 PID：${it.groupValues[1]}"
        }
        Regex("""^Divergent: (.*)$""").matchEntire(text)?.let {
            return "存在差异：${it.groupValues[1]}"
        }
        Regex("""^Root token hit: (.*)$""").matchEntire(text)?.let {
            return "Root 标记命中：${it.groupValues[1]}"
        }
        Regex("""^Matched token: (.*)$""").matchEntire(text)?.let {
            return "匹配标记：${it.groupValues[1]}"
        }
        Regex("""^Matched mountinfo line: (.*)$""").matchEntire(text)?.let {
            return "匹配的 mountinfo 行：${it.groupValues[1]}"
        }
        Regex("""^Detail: (.*)$""").matchEntire(text)?.let {
            return "详情：${it.groupValues[1]}"
        }
        Regex("""^Source: (.*)$""").matchEntire(text)?.let {
            return "来源：${it.groupValues[1]}"
        }
        Regex("""^Category: (.*)$""").matchEntire(text)?.let {
            return "类别：${it.groupValues[1]}"
        }
        Regex("""^Observed: (.*)$""").matchEntire(text)?.let {
            return "观察值：${it.groupValues[1]}"
        }
        Regex("""^Allowed: (.*)$""").matchEntire(text)?.let {
            return "允许：${it.groupValues[1]}"
        }
        Regex("""^Denied: (.*)$""").matchEntire(text)?.let {
            return "拒绝：${it.groupValues[1]}"
        }
        Regex("""^Unavailable: (.*)$""").matchEntire(text)?.let {
            return "不可用：${it.groupValues[1]}"
        }
        Regex("""^Missing: (.*)$""").matchEntire(text)?.let {
            return "缺失：${it.groupValues[1]}"
        }
        Regex("""^Dirty sepolicy rule: (.*)$""").matchEntire(text)?.let {
            return "异常 SELinux 策略规则：${it.groupValues[1]}"
        }
        Regex("""^Droidspaces checker: (.*)$""").matchEntire(text)?.let {
            return "Droidspaces 检查：${it.groupValues[1]}"
        }
        Regex("""^MSD checker: (.*)$""").matchEntire(text)?.let {
            return "MSD 检查：${it.groupValues[1]}"
        }
        Regex("""^Droidspaces: (.*)$""").matchEntire(text)?.let {
            return "Droidspaces：${it.groupValues[1]}"
        }
        Regex("""^MSD: (.*)$""").matchEntire(text)?.let {
            return "MSD：${it.groupValues[1]}"
        }
        Regex("""^Checked (\d+) process contexts; (\d+) /proc reads were denied\. Denied reads are kept as supporting visibility evidence, not direct root-process proof\.$""")
            .matchEntire(text)?.let {
                return "已检查 ${it.groupValues[1]} 个进程上下文，其中 ${it.groupValues[2]} 次 /proc 读取被拒绝。读取被拒仅作为可见性辅助证据，不直接证明存在 Root 进程。"
            }
        Regex("""^(.+) footprints were found under /data/adb, which is a direct root-management signal\.$""")
            .matchEntire(text)?.let {
                return "在 /data/adb 下发现 ${it.groupValues[1]} 痕迹，这是直接的 Root 管理信号。"
            }
        if (text.endsWith(" The read-only ksu_driver probe was blocked by app seccomp on this device, so the verdict falls back to prctl, self-process IOC, path, cgroup, kernel-string, and property evidence.")) {
            val prefix = text.removeSuffix(" The read-only ksu_driver probe was blocked by app seccomp on this device, so the verdict falls back to prctl, self-process IOC, path, cgroup, kernel-string, and property evidence.")
            return "${translate(prefix)} 此设备上的只读 ksu_driver 探针被应用 seccomp 阻止，因此结论将退回使用 prctl、当前进程 IOC、路径、cgroup、内核字符串和属性证据。"
        }
        if (text.endsWith(" The read-only ksu_driver probe was unavailable, so this card relied on the remaining native checks.")) {
            val prefix = text.removeSuffix(" The read-only ksu_driver probe was unavailable, so this card relied on the remaining native checks.")
            return "${translate(prefix)} 只读 ksu_driver 探针不可用，因此此卡片使用其余原生检查进行判断。"
        }
        if (text == "The sacrificial reboot() helper died under app seccomp before it could install a temporary [ksu_driver] fd. Other KernelSU checks still ran.") {
            return "牺牲用的 reboot() 辅助进程在安装临时 [ksu_driver] 文件描述符之前被应用 seccomp 终止；其他 KernelSU 检查仍已运行。"
        }
        Regex("""^Tracked property area, serial, and residual value checks were clean; checked (\d+) tracked property name\(s\) across (\d+) property-area context\(s\)$""")
            .matchEntire(text)?.let {
                return "属性区、序列号与残留值检查未发现异常；已检查 ${it.groupValues[1]} 个跟踪属性名，覆盖 ${it.groupValues[2]} 个属性区上下文。"
            }
        if (text.endsWith(" detected") && (" signature" in text || " signal(s)" in text)) {
            val body = text.removeSuffix(" detected")
            val translatedParts = body.split(" + ").joinToString(" + ") { part ->
                when {
                    part.endsWith(" signature") -> "${part.removeSuffix(" signature")} 特征"
                    Regex("""^\d+ ROM signatures$""").matches(part) -> translate(part)
                    Regex("""^\d+ modification signal\(s\)$""").matches(part) -> translate(part)
                    Regex("""^\d+ native symbol trace\(s\)$""").matches(part) -> translate(part)
                    else -> translate(part)
                }
            }
            return "检测到 ${translatedParts}"
        }
        if (text.startsWith("The dedicated app_zygote carrier hit anomalous /proc/self/attr/current write outcomes while probing privileged contexts: ")) {
            return "专用 app_zygote 载体在探测特权上下文时发现 /proc/self/attr/current 写入结果异常：" +
                text.removePrefix("The dedicated app_zygote carrier hit anomalous /proc/self/attr/current write outcomes while probing privileged contexts: ")
        }
        if (text.startsWith("The dedicated app_zygote carrier observed anomalous /proc/self/attr/current writes for ")) {
            return "专用 app_zygote 载体观察到以下上下文的 /proc/self/attr/current 写入异常：" +
                text.removePrefix("The dedicated app_zygote carrier observed anomalous /proc/self/attr/current writes for ")
        }
        Regex("""^A trusted DirtySepolicy-style access query reported (.+) as allowed\.$""")
            .matchEntire(text)?.let {
                return "受信任的 DirtySepolicy 风格访问查询显示 ${it.groupValues[1]} 被允许。"
            }
        Regex("""^A trusted DirtySepolicy-style access rule was allowed: (.+)\.$""")
            .matchEntire(text)?.let {
                return "受信任的 DirtySepolicy 风格访问规则被允许：${it.groupValues[1]}。"
            }
        Regex("""^View target apps \((\d+)\)$""").matchEntire(text)?.let {
            return "查看目标应用（${it.groupValues[1]}）"
        }
        Regex("""^(.+) \((\d+)\)$""").matchEntire(text)?.let {
            val translatedLabel = translate(it.groupValues[1])
            if (translatedLabel != it.groupValues[1]) {
                return "${translatedLabel}（${it.groupValues[2]}）"
            }
        }
        Regex("""^([^:\\n]{1,80}): (.*)$""").matchEntire(text)?.let {
            val translatedLabel = translate(it.groupValues[1])
            if (translatedLabel != it.groupValues[1]) {
                return "${translatedLabel}：${it.groupValues[2]}"
            }
        }
        if (text.startsWith("Scanned at ") && "\nTotal time " in text) {
            return text.replaceFirst("Scanned at ", "扫描时间：").replace("\nTotal time ", "\n总耗时：")
        }
        for ((pattern, replacement) in countPatterns) {
            pattern.matchEntire(text)?.let { return replacement(it) }
        }
        return text
    }
}
