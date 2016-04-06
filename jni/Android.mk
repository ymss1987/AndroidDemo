LOCAL_PATH :=$(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := TestJni

LOCAL_SRC_FILES :=com_example_testjni_TestJni.cpp
LOCAL_SRC_FILES +=Add.cpp

include $(BUILD_SHARED_LIBRARY)