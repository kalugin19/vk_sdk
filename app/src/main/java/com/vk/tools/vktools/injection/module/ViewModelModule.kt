package com.vk.tools.vktools.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vk.tools.vktools.injection.scope.ViewModelKey
import com.vk.tools.vktools.view_model.FriendsViewModel
import com.vk.tools.vktools.view_model.VkToolViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: VkToolViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FriendsViewModel::class)
    abstract fun  bindFriendsViewModel(friendsViewModel: FriendsViewModel): ViewModel

    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(LoginViewModel.class)
    //    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(WorkEntityViewModel.class)
    //    abstract ViewModel bindWorkEntityViewModel(WorkEntityViewModel loginViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(CounterRenewalViewModel.class)
    //    abstract ViewModel bindMeterReadingViewModel(CounterRenewalViewModel loginViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(EmrWorkViewModel.class)
    //    abstract ViewModel bindEmrWorkViewModel(EmrWorkViewModel emrWorkViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(SplashViewModel.class)
    //    abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(CoordinateWorkViewModel.class)
    //    abstract ViewModel bindCoordinateWorkViewModel(CoordinateWorkViewModel coordinateWorkViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(NewWorksViewModel.class)
    //    abstract ViewModel bindNewWorksViewModel(NewWorksViewModel newWorksViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(PlanWorksViewModel.class)
    //    abstract ViewModel bindPlanWorksViewModel(PlanWorksViewModel planWorksViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(DoneWorksViewModel.class)
    //    abstract ViewModel bindDoneWorksViewModel(DoneWorksViewModel doneWorksViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(TimerViewModel.class)
    //    abstract ViewModel bindTimerViewModel(TimerViewModel timerViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(FilterAllWorkViewModel.class)
    //    abstract ViewModel bindFilterAllWorkViewModel(FilterAllWorkViewModel filterAllWorkViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(MainAllWorksViewModel.class)
    //    abstract ViewModel bindMainAllWorksViewModel(MainAllWorksViewModel mainAllWorksViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(PhotoListViewModel.class)
    //    abstract ViewModel bindPhotoListViewModel(PhotoListViewModel photoListViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(WorkCardViewModel.class)
    //    abstract ViewModel bindWorkCardViewModel(WorkCardViewModel workCardViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(TodayViewModel.class)
    //    abstract ViewModel bindTodayViewModel(TodayViewModel todayViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ScheduledPlanViewModel.class)
    //    abstract ViewModel bindScheduledPlanViewModel(ScheduledPlanViewModel scheduledPlanViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(GalleryViewModel.class)
    //    abstract ViewModel bindGalleryViewModel(GalleryViewModel galleryViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(BaseActionsViewModel.class)
    //    abstract ViewModel bindBaseActionsViewModel(BaseActionsViewModel baseActionsViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ActionDialogViewModel.class)
    //    abstract ViewModel bindActionDialogViewModel(ActionDialogViewModel actionDialogViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(MoreScreenViewModel.class)
    //    abstract ViewModel bindMoreScreenViewModel(MoreScreenViewModel moreScreenViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ServiceViewModel.class)
    //    abstract ViewModel bindServiceViewModel(ServiceViewModel serviceViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ScheduledPlanMapViewModel.class)
    //    abstract ViewModel bindScheduledPlanMapViewModel(ScheduledPlanMapViewModel serviceViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(NotificationViewModel.class)
    //    abstract ViewModel bindNotificationViewModel(NotificationViewModel notificationViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(MainViewModel.class)
    //    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}
