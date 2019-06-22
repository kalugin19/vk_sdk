package com.vk.tools.vktools.injection.module

import com.vk.tools.vktools.view.friends.FriendsFragment
import com.vk.tools.vktools.view.friends.MainFriendsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * FragmentBuildersModule
 */
@Module
abstract class FragmentBuildersModule{

    @ContributesAndroidInjector
    abstract fun contributeFriendsFragment(): FriendsFragment

    @ContributesAndroidInjector
    abstract fun contributeMainFriendsFragment(): MainFriendsFragment
}
//    @ContributesAndroidInjector
//    abstract OldCounterFragment contributeOldCounterFragment();
//
//    @ContributesAndroidInjector
//    abstract NewCounterFragment contributeNewCounterFragment();
//
//    @ContributesAndroidInjector
//    abstract MeterReadingFragment contributeMeterReadingFragment();
//
//    @ContributesAndroidInjector
//    abstract WorksFilteredFragment contributeAllWorksFilteredFragment();
//
//    @ContributesAndroidInjector
//    abstract AllWorksFragment contributeAllWorksFragment();
//
//    @ContributesAndroidInjector
//    abstract MoreFragment contributeMoreFragment();
//
//    @ContributesAndroidInjector
//    abstract TodayListFragment contributeTodayListFragment();
//
//    @ContributesAndroidInjector
//    abstract TodayMapFragment contributeTodayMapFragment();
//
//    @ContributesAndroidInjector
//    abstract TodayFragment contributeTodayFragment();
//
//    @ContributesAndroidInjector
//    abstract PhotoListFragment contributePhotoListFragment();
//
//    @PerFragment
//    @ContributesAndroidInjector
//    abstract RequisitesFragment contributeRequisitesFragment();
//
//    @PerFragment
//    @ContributesAndroidInjector
//    abstract AboutOrderFragment contributeAboutOrderFragment();
//
//    @ContributesAndroidInjector
//    abstract ConfirmationOfSendingWorkDialogFragment contributeConfirmationOfSendingWorkDialogFragment();
//
//    @ContributesAndroidInjector
//    abstract WeekFragment contributeWeekFragment();
//
//    @ContributesAndroidInjector
//    abstract ScheduledPlanFragment contributeScheduledPlanFragment();
//
//    @ContributesAndroidInjector
//    abstract ScheduledPlanListFragment contributeScheduledPlanListFragment();
//
//    @ContributesAndroidInjector
//    abstract ScheduledPlanMapFragment contributeScheduledPlanMapFragment();
//
//    @ContributesAndroidInjector
//    abstract ViewWorkDialogFragment contributeViewWorkDialogFragment();
//
//    @ContributesAndroidInjector
//    abstract ActionDialogFragment contributeActionDialogFragment();
//
//    @ContributesAndroidInjector
//    abstract ToolbarActionFragment contributeToolbarActionFragment();
//
//    @ContributesAndroidInjector
//    abstract MapFragment contributeMapFragment();