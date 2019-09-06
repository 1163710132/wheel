package com.chen1144.wheel.util;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class Subscribers {
    public static <T> Flow.Subscriber<T> single(Consumer<T> onSuccess, Consumer<Throwable> onFailed){
        return new Flow.Subscriber<T>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.request(1);
            }

            @Override
            public void onNext(T item) {
                onSuccess.accept(item);
            }

            @Override
            public void onError(Throwable throwable) {
                onFailed.accept(throwable);
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
