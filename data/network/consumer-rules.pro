#-dontwarn java.lang.invoke.StringConcatFactory
#-keep class io.boshra.filmtime.data.network.response.TmdbErrorResponse { *; }
#-keep class io.boshra.filmtime.data.network.response.TmdbMovieDetailsResponse { *; }
#-keep class io.boshra.filmtime.data.network.response.Genre{ *; }
#-keep class io.boshra.filmtime.data.network.response.ProductionCompany{ *; }
#-keep class io.boshra.filmtime.data.network.response.SpokenLanguage{ *; }
#-keep class io.boshra.filmtime.data.network.response.TmdbShowsListResponse{ *; }
#-keep class io.boshra.filmtime.data.network.response.TmdbShowResultResponse{ *; }
#-keep class io.boshra.filmtime.data.network.response.TmdbVideoListResponse{ *; }
#-keep class io.boshra.filmtime.data.network.response.TmdbVideoResultResponse{ *; }

-keep class io.boshra.filmtime.data.network.adapter.NetworkResponse{*;}
-keep class io.boshra.filmtime.data.network.adapter.NetworkResponseAdapter {*;}
-keep class io.boshra.filmtime.data.network.adapter.NetworkCallAdapterFactory{*;}
-keep class io.boshra.filmtime.data.network.adapter.NetworkResponseCall{*;}
#-keep interface io.boshra.filmtime.data.network.TmdbMoviesService {*;}
#-keep interface io.boshra.filmtime.data.network.TmdbShowsService {*;}

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# R8 full mode strips generic signatures from return types if not kept.
# -if interface * { @retrofit2.http.* public *** *(...); }
# -keep,allowoptimization,allowshrinking,allowobfuscation class <3>

#-keep public class * implements java.lang.reflect.Type
#-keepattributes *Annotation*
#-keepattributes Signature
#-keep,allowobfuscation,allowshrinking interface retrofit2.Call
#-keep,allowobfuscation,allowshrinking class retrofit2.Response

#-keep class kotlin.reflect.** { *; }
#-dontwarn kotlin.reflect.**
#-keep class org.jetbrains.** { *; }

#-keep class dagger.** { *; }
#-keep interface dagger.** { *; }
#-keep class javax.inject.** { *; }
#-keep interface javax.inject.** { *; }

#-keepnames class kotlinx.serialization.** { *; }
#-keepnames class kotlin.Metadata { *; }
#-keepclassmembers class **$Companion {
#    public static ** serializer(...);
#}
#
#-keepclassmembers class ** {
#    public static kotlinx.serialization.descriptors.SerialDescriptor SERIALIZER$;
#    public static kotlinx.serialization.KSerializer SERIALIZER$;
#    public static kotlinx.serialization.KSerializer serializer(...);
#}