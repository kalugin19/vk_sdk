package com.vk.tools.vktools.injection.module

import dagger.Module


/**
 * AppModule
 */
@Module(includes = [ViewModelModule::class])
class AppModule//    private static final String BUILD_TYPE_MASTER = "master";
//    @Singleton
//    @Provides
//    SumpDatabase provideDb(Application app) {
//        if (TextUtilsCustom.equalsIgnoreCase(BUILD_TYPE_MASTER, BuildConfig.BUILD_TYPE)) {
//            return Room.databaseBuilder(app, SumpDatabase.class, "sum.db").build();
//        }
//        return Room.databaseBuilder(app, SumpDatabase.class, "sum.db").fallbackToDestructiveMigration().build();
//    }
//
//    @Singleton
//    @Provides
//    UserDaoWrapper provideUserDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new UserDaoWrapper(context, db.userDao());
//    }
//
//
//    @Singleton
//    @Provides
//    SettingsDaoWrapper provideSettingsDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new SettingsDaoWrapper(context, db.settingsDao());
//    }
//
//    @Singleton
//    @Provides
//    OrganizationalUnitsDaoWrapper provideOrganizationalUnitsDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new OrganizationalUnitsDaoWrapper(context, db.organizationalUnitsDao());
//    }
//
//    @Singleton
//    @Provides
//    SchemaDaoWrapper provideSchemaDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new SchemaDaoWrapper(context, db.schemaDao());
//    }
//
//    @Singleton
//    @Provides
//    QueueDaoWrapper provideQueueDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new QueueDaoWrapper(context, db.queueDao());
//    }
//
//    @Singleton
//    @Provides
//    CounterDaoWrapper provideCounterDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new CounterDaoWrapper(context, db.counterDao());
//    }
//
//
//    @Singleton
//    @Provides
//    DictionaryDaoWrapper provideDictionaryDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new DictionaryDaoWrapper(context, db.getDictionaryDao());
//    }
//
//    @Singleton
//    @Provides
//    WorkDaoWrapper provideWorkDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new WorkDaoWrapper(context, db.workDao());
//    }
//
//    @Singleton
//    @Provides
//    WorkStateDaoWrapper provideWorkState(@ApplicationContext Context context, SumpDatabase db) {
//        return new WorkStateDaoWrapper(context, db.workStateDao());
//    }
//
//    @Singleton
//    @Provides
//    AccomplishmentDao provideAccomplishment(SumpDatabase db) {
//        return db.accomplishmentDao();
//    }
//
//    @Singleton
//    @Provides
//    AdditionalContactDao provideAdditionalContact(SumpDatabase db) {
//        return db.additionalContactDao();
//    }
//
//    @Singleton
//    @Provides
//    AgreementDaoWrapper provideAgreement(@ApplicationContext Context context, SumpDatabase db) {
//        return new AgreementDaoWrapper(context, db.agreementDao());
//    }
//
//    @Singleton
//    @Provides
//    CounterReplacementDao provideCounterReplacement(SumpDatabase db) {
//        return db.counterReplacementDao();
//    }
//
//    @Singleton
//    @Provides
//    CounterInstallationPlaceDaoWrapper provideCounterInstallationPlace(@ApplicationContext Context context, SumpDatabase db) {
//        return new CounterInstallationPlaceDaoWrapper(context, db.counterInstallationPlaceDao());
//    }
//
//    @Singleton
//    @Provides
//    WorkUpdateFactoryWrapper provideWorkUpdateFactory(@ApplicationContext Context context, SumpDatabase db) {
//        return new WorkUpdateFactoryWrapper(context, db.workUpdateFactory());
//    }
//
//    @Singleton
//    @Provides
//    RPCService provideRpcService(@ApplicationContext Context context) {
//        return RetrofitHelper.getInstance().newRpcService(context);
//    }
//
//    @Provides
//    @Singleton
//    @ApplicationContext
//    Context provideAppContext(Application application) {
//        return application;
//    }
//
//    @Provides
//    @Singleton
//    ConnectionService provideConnectionService(Application application) {
//        return new ConnectionService(application);
//    }
//
//    @Singleton
//    @Provides
//    QueuePreferenceHelper provideQueuePreferenceHelper(PreferencesHelper preferencesHelper) {
//        return new QueuePreferenceHelper(preferencesHelper);
//    }
//
//    @Singleton
//    @Provides
//    UtilPreferencesHelper provideUtilPreferencesHelper(PreferencesHelper preferencesHelper) {
//        return new UtilPreferencesHelper(preferencesHelper);
//    }
//
//    @Singleton
//    @Provides
//    PhotoDaoWrapper providePhotoDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new PhotoDaoWrapper(context, db.workPhotoDao());
//    }
//
//    @Singleton
//    @Provides
//    NotificationDaoWrapper provideNotificationDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new NotificationDaoWrapper(context, db.notificationDao());
//    }
//
//    @Singleton
//    @Provides
//    RouteDaoWrapper provideRouteDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new RouteDaoWrapper(context, db.routeDao());
//    }
//
//    @Singleton
//    @Provides
//    ComplaintDao provideComplaintDao(SumpDatabase db) {
//        return db.complaintDao();
//    }
//
//    @Singleton
//    @Provides
//    WorkEventDao provideWorkEventDao(SumpDatabase db) {
//        return db.workEventDao();
//    }
//
//    @Singleton
//    @Provides
//    CuratorDaoWrapper provideCuratorDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new CuratorDaoWrapper(context, db.curatorDao());
//    }
//
//    @Singleton
//    @Provides
//    UserInfoDaoWrapper provideUserInfoDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new UserInfoDaoWrapper(context, db.userInfoDao());
//    }
//
//    @Singleton
//    @Provides
//    StockDaoWrapper provideStockDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new StockDaoWrapper(context, db.stockDao());
//    }
//
//    @Singleton
//    @Provides
//    WorkCommentDao provideWorkCommentDao(SumpDatabase db) {
//        return db.workCommentDao();
//    }
//
//    @Provides
//    @Singleton
//    NotificationUtil provideNotificationService(Application application) {
//        return new NotificationUtil(application);
//    }
//
//    @Singleton
//    @Provides
//    PriceDaoWrapper providePriceDao(@ApplicationContext Context context, SumpDatabase db) {
//        return new PriceDaoWrapper(context, db.priceDao());
//    }