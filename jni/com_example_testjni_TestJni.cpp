#include<stdlib.h>
#include<stdio.h>
#include "Add.h"
#include "com_example_testjni_TestJni.h"


CAdd *pCAdd=NULL;

JNIEXPORT jboolean JNICALL Java_com_example_testjni_TestJni_init
  (JNIEnv *env, jobject obj)
{
if (pCAdd == NULL)
{
pCAdd = new CAdd;
}
return pCAdd!=NULL;
}

JNIEXPORT jint JNICALL Java_com_example_testjni_TestJni_add
  (JNIEnv *env, jobject obj, jint x, jint y)
{
	jint result = -1;
	if (pCAdd!=NULL)
	{
		result = pCAdd->add(x,y);
	}
	return result;
}

JNIEXPORT void JNICALL Java_com_example_testjni_TestJni_destory
  (JNIEnv *, jobject)
{
	if (pCAdd!=NULL)
	{
		delete pCAdd;
		pCAdd=NULL;
	}
}


