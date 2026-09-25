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

import com.dchecker.info.core.ui.model.DetectionSeverity
import com.dchecker.info.core.ui.model.DetectorStatus
import com.dchecker.info.core.ui.model.InfoKind
import com.dchecker.info.core.ui.components.HomeChineseText
import com.dchecker.info.features.bootloader.ui.model.BootloaderCardModel
import com.dchecker.info.features.customrom.ui.model.CustomRomCardModel
import com.dchecker.info.features.deviceinfo.ui.model.DeviceInfoCardModel
import com.dchecker.info.features.dangerousapps.ui.model.DangerousAppsCardModel
import com.dchecker.info.features.kernelcheck.ui.model.KernelCheckCardModel
import com.dchecker.info.features.lsposed.ui.model.LSPosedCardModel
import com.dchecker.info.features.memory.ui.model.MemoryCardModel
import com.dchecker.info.features.mount.ui.model.MountCardModel
import com.dchecker.info.features.nativeroot.ui.model.NativeRootCardModel
import com.dchecker.info.features.playintegrityfix.ui.model.PlayIntegrityFixCardModel
import com.dchecker.info.features.selinux.ui.model.SelinuxCardModel
import com.dchecker.info.features.su.ui.model.SuCardModel
import com.dchecker.info.features.systemproperties.ui.model.SystemPropertiesCardModel
import com.dchecker.info.features.tee.ui.model.TeeCardModel
import com.dchecker.info.features.virtualization.ui.model.VirtualizationCardModel
import com.dchecker.info.features.zygisk.ui.model.ZygiskCardModel
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

data class DashboardOverviewMetricModel(
    val label: String,
    val value: String,
    val status: DetectorStatus,
)

data class DashboardOverviewModel(
    val title: String,
    val headline: String,
    val summary: String,
    val status: DetectorStatus,
    val metrics: List<DashboardOverviewMetricModel>,
    val showTitleIcon: Boolean = false,
)

data class DashboardFindingModel(
    val detectorTitle: String,
    val headline: String,
    val detail: String,
    val status: DetectorStatus,
)

data class DashboardDetectorContribution(
    val id: String,
    val title: String,
    val status: DetectorStatus,
    val headline: String,
    val summary: String,
    val ready: Boolean,
    // Optional summary override for compact Dashboard findings; detector cards keep their full detail.
    // Dashboard 顶层 findings 的可选短摘要；detector 卡片仍保留完整细节。
    val findingDetail: String? = null,
)

sealed interface DashboardDetectorCardEntry {
    val id: String
    val status: DetectorStatus

    data class Bootloader(
        val model: BootloaderCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "bootloader"
        override val status: DetectorStatus = model.status
    }

    data class Mount(
        val model: MountCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "mount"
        override val status: DetectorStatus = model.status
    }

    data class Memory(
        val model: MemoryCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "memory"
        override val status: DetectorStatus = model.status
    }

    data class LSPosed(
        val model: LSPosedCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "lsposed"
        override val status: DetectorStatus = model.status
    }

    data class Selinux(
        val model: SelinuxCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "selinux"
        override val status: DetectorStatus = model.status
    }

    data class DangerousApps(
        val model: DangerousAppsCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "dangerous_apps"
        override val status: DetectorStatus = model.status
    }

    data class PlayIntegrityFix(
        val model: PlayIntegrityFixCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "play_integrity_fix"
        override val status: DetectorStatus = model.status
    }

    data class NativeRoot(
        val model: NativeRootCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "native_root"
        override val status: DetectorStatus = model.status
    }

    data class Tee(
        val model: TeeCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "tee"
        override val status: DetectorStatus = model.status
    }

    data class Su(
        val model: SuCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "su"
        override val status: DetectorStatus = model.status
    }

    data class CustomRom(
        val model: CustomRomCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "custom_rom"
        override val status: DetectorStatus = model.status
    }

    data class KernelCheck(
        val model: KernelCheckCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "kernel_check"
        override val status: DetectorStatus = model.status
    }

    data class SystemProperties(
        val model: SystemPropertiesCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "system_properties"
        override val status: DetectorStatus = model.status
    }

    data class Zygisk(
        val model: ZygiskCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "zygisk"
        override val status: DetectorStatus = model.status
    }

    data class Virtualization(
        val model: VirtualizationCardModel,
    ) : DashboardDetectorCardEntry {
        override val id: String = "virtualization"
        override val status: DetectorStatus = model.status
    }
}

data class DashboardUiState(
    val overview: DashboardOverviewModel,
    val topFindings: List<DashboardFindingModel>,
    val detectorCards: List<DashboardDetectorCardEntry>,
    val deviceInfoCard: DeviceInfoCardModel,
    val isLoading: Boolean,
)

fun buildDashboardOverview(
    contributions: List<DashboardDetectorContribution>,
    scanDurationMillis: Long? = null,
    scanCompletedAtEpochMillis: Long? = null,
    chinese: Boolean = false,
): DashboardOverviewModel {
    val total = contributions.size
    val readyCount = contributions.count { it.ready }
    val pendingCount = total - readyCount
    val dangerCount = contributions.count { it.status.severity == DetectionSeverity.DANGER }
    val warningCount = contributions.count { it.status.severity == DetectionSeverity.WARNING }
    val infoErrorCount = contributions.count {
        it.status.severity == DetectionSeverity.INFO && it.status.infoKind == InfoKind.ERROR
    }

    val focusTitles = prioritizedContributions(contributions)
        .take(2)
        .map { if (chinese) HomeChineseText.translate(it.title) else it.title }

    val overviewStatus = when {
        dangerCount > 0 -> DetectorStatus.danger()
        warningCount > 0 -> DetectorStatus.warning()
        infoErrorCount > 0 -> DetectorStatus.info(InfoKind.ERROR)
        readyCount == 0 -> DetectorStatus.info(InfoKind.SUPPORT)
        pendingCount > 0 -> DetectorStatus.info(InfoKind.SUPPORT)
        else -> DetectorStatus.allClear()
    }

    val focus = focusTitles.joinToString(separator = if (chinese) "和" else " and ")
    val headline = when {
        dangerCount > 0 -> if (chinese) "危险" else "Danger"
        warningCount > 0 -> if (chinese) "警告" else "Warning"
        infoErrorCount > 0 -> if (chinese) "信息" else "Info"
        readyCount == 0 -> if (chinese) "准备中" else "Ready"
        pendingCount > 0 -> if (chinese) "等待中" else "Pending"
        else -> if (chinese) "正常" else "OK"
    }

    val summary = if (chinese) {
        when {
            dangerCount > 0 -> "请先检查${focus}。"
            warningCount > 0 -> "接下来请核查${focus}。"
            infoErrorCount > 0 -> "${focus}需要更多信息，暂不能认定结果正常。"
            readyCount == 0 -> "本地检测完成后将显示检测卡片。"
            pendingCount > 0 -> "部分模块仍在收集本地证据。"
            else -> "请在下方检测卡片中查看本地证据。"
        }
    } else {
        when {
            dangerCount > 0 -> "Start with ${focus}."
            warningCount > 0 -> "Review ${focus} next."
            infoErrorCount > 0 -> "${focus} need more context before treating results as clean."
            readyCount == 0 -> "Detector cards will populate as local checks complete."
            pendingCount > 0 -> "Additional modules are still collecting their local evidence."
            else -> "Use the detector cards below to inspect local evidence in detail."
        }
    }

    return DashboardOverviewModel(
        title = if (scanDurationMillis != null && scanCompletedAtEpochMillis != null && pendingCount == 0) {
            if (chinese) {
                "扫描时间：${formatDetectedTimeLocal(scanCompletedAtEpochMillis)}\n总耗时：${formatScanDuration(scanDurationMillis, chinese = true)}"
            } else {
                "Scanned at ${formatDetectedTimeLocal(scanCompletedAtEpochMillis)}\nTotal time ${formatScanDuration(scanDurationMillis)}"
            }
        } else {
            if (chinese) "安全概览" else "Security overview"
        },
        headline = headline,
        summary = summary,
        status = overviewStatus,
        metrics = listOf(
            DashboardOverviewMetricModel(
                label = if (chinese) "危险" else "Danger",
                value = dangerCount.toString(),
                status = if (dangerCount > 0) DetectorStatus.danger() else DetectorStatus.allClear(),
            ),
            DashboardOverviewMetricModel(
                label = if (chinese) "警告" else "Warning",
                value = warningCount.toString(),
                status = if (warningCount > 0) DetectorStatus.warning() else DetectorStatus.allClear(),
            ),
            DashboardOverviewMetricModel(
                label = if (chinese) "已完成" else "Ready",
                value = readyCount.toString(),
                status = if (readyCount > 0) DetectorStatus.allClear() else DetectorStatus.info(
                    InfoKind.SUPPORT
                ),
            ),
            DashboardOverviewMetricModel(
                label = if (chinese) "等待中" else "Pending",
                value = pendingCount.toString(),
                status = if (pendingCount > 0) DetectorStatus.info(InfoKind.SUPPORT) else DetectorStatus.allClear(),
            ),
        ),
        showTitleIcon = scanDurationMillis != null && pendingCount == 0,
    )
}

private fun formatDetectedTimeLocal(epochMillis: Long): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US)
    return Instant.ofEpochMilli(epochMillis)
        .atZone(ZoneId.systemDefault())
        .format(formatter)
}

private fun formatScanDuration(
    durationMillis: Long,
    chinese: Boolean = false,
): String {
    return when {
        durationMillis < 1_000L -> if (chinese) "${durationMillis} 毫秒" else "${durationMillis}ms"
        durationMillis < 10_000L -> String.format(
            Locale.US,
            if (chinese) "%.1f 秒" else "%.1fs",
            durationMillis / 1_000f,
        )
        else -> "${(durationMillis + 500L) / 1_000L}${if (chinese) " 秒" else "s"}"
    }
}

fun buildDashboardFindings(
    contributions: List<DashboardDetectorContribution>,
    chinese: Boolean = false,
): List<DashboardFindingModel> {
    val prioritized = prioritizedContributions(contributions)
    val attentionFindings = prioritized.filter { contribution ->
        when (contribution.status.severity) {
            DetectionSeverity.DANGER,
            DetectionSeverity.WARNING -> true

            DetectionSeverity.INFO -> contribution.status.infoKind == InfoKind.ERROR
            DetectionSeverity.ALL_CLEAR -> false
        }
    }
    if (attentionFindings.isNotEmpty()) {
        return attentionFindings.take(3).map { contribution ->
            DashboardFindingModel(
                detectorTitle = if (chinese) HomeChineseText.translate(contribution.title) else contribution.title,
                headline = if (chinese) HomeChineseText.translate(contribution.headline) else contribution.headline,
                detail = if (chinese) HomeChineseText.translate(contribution.findingDetail ?: contribution.summary)
                    else contribution.findingDetail ?: contribution.summary,
                status = contribution.status,
            )
        }
    }

    if (contributions.any { !it.ready }) {
        return listOf(
            DashboardFindingModel(
                detectorTitle = if (chinese) "扫描状态" else "Scan status",
                headline = if (chinese) "等待检测证据" else "Waiting for detector evidence",
                detail = if (chinese) "各模块收集完本地证据后会展开检测卡片。"
                    else "Detector cards will expand as modules finish collecting local evidence.",
                status = DetectorStatus.info(InfoKind.SUPPORT),
            ),
        )
    }

    return listOf(
        DashboardFindingModel(
            detectorTitle = if (chinese) "概览" else "Overview",
            headline = if (chinese) "已完成项目中无紧急发现" else "No urgent findings in ready modules",
            detail = if (chinese) "展开下方检测卡片，查看详细证据及补充检查。"
                else "Open detector cards below to review detailed local evidence and secondary checks.",
            status = DetectorStatus.allClear(),
        ),
    )
}

private fun prioritizedContributions(
    contributions: List<DashboardDetectorContribution>,
): List<DashboardDetectorContribution> {
    return contributions.sortedWith(
        compareBy<DashboardDetectorContribution> { contribution ->
            detectorPriority(contribution.status)
        }.thenBy { if (it.ready) 0 else 1 }
            .thenBy { it.title },
    )
}

fun sortDashboardDetectorCards(
    entries: List<DashboardDetectorCardEntry>,
): List<DashboardDetectorCardEntry> {
    return entries.sortedWith(
        compareBy<DashboardDetectorCardEntry> { entry ->
            detectorPriority(entry.status)
        }.thenBy { entry ->
            when (entry) {
                is DashboardDetectorCardEntry.Bootloader -> entry.model.title
                is DashboardDetectorCardEntry.CustomRom -> entry.model.title
                is DashboardDetectorCardEntry.DangerousApps -> entry.model.title
                is DashboardDetectorCardEntry.KernelCheck -> entry.model.title
                is DashboardDetectorCardEntry.LSPosed -> entry.model.title
                is DashboardDetectorCardEntry.Memory -> entry.model.title
                is DashboardDetectorCardEntry.Mount -> entry.model.title
                is DashboardDetectorCardEntry.NativeRoot -> entry.model.title
                is DashboardDetectorCardEntry.PlayIntegrityFix -> entry.model.title
                is DashboardDetectorCardEntry.Selinux -> entry.model.title
                is DashboardDetectorCardEntry.Su -> entry.model.title
                is DashboardDetectorCardEntry.SystemProperties -> entry.model.title
                is DashboardDetectorCardEntry.Tee -> entry.model.title
                is DashboardDetectorCardEntry.Virtualization -> entry.model.title
                is DashboardDetectorCardEntry.Zygisk -> entry.model.title
            }
        },
    )
}

private fun detectorPriority(
    status: DetectorStatus,
): Int {
    return when (status.severity) {
        DetectionSeverity.DANGER -> 0
        DetectionSeverity.WARNING -> 1
        DetectionSeverity.INFO -> if (status.infoKind == InfoKind.ERROR) 2 else 3
        DetectionSeverity.ALL_CLEAR -> 4
    }
}
