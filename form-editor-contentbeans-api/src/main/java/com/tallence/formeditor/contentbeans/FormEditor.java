/*
 * Copyright 2018 Tallence AG
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

package com.tallence.formeditor.contentbeans;

import com.coremedia.blueprint.common.contentbeans.CMTeasable;
import com.coremedia.cae.aspect.Aspect;
import com.coremedia.cap.struct.Struct;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * ContentBean for Form Configuration documents.
 *
 */
public interface FormEditor extends CMTeasable {

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'FormEditor'.
   */
  String NAME = "FormEditor";

  /**
   * Returns the value of the document property {@link #MASTER}.
   *
   * @return a {@link FormEditor} object
   */
  @Override
  FormEditor getMaster();

  /**
   * Returns the variants of this {@link FormEditor} indexed by their {@link Locale}
   *
   * @return the variants of this {@link FormEditor} indexed by their {@link Locale}
   */
  @Override
  Map<Locale, ? extends FormEditor> getVariantsByLocale();

  /**
   * Returns the {@link Locale} specific variants of this {@link FormEditor}
   *
   * @return the {@link Locale} specific variants of this {@link FormEditor}
   */
  @Override
  Collection<? extends FormEditor> getLocalizations();

  /**
   * Returns a <code>Map</code> from aspectIDs to Aspects. AspectIDs consists of an aspect name with a
   * prefix which identifies the plugin provider.
   *
   * @return a <code>Map</code> from aspectIDs to <code>Aspect</code>s
   */
  @Override
  Map<String, ? extends Aspect<? extends FormEditor>> getAspectByName();

  /**
   * Returns a list of all  <code>Aspect</code>s from all availiable
   * PlugIns that are registered to this content bean.
   *
   * @return a list of {@link Aspect}
   */
  @Override
  List<? extends Aspect<? extends FormEditor>> getAspects();

  /**
   * Resolves the configured formElement.
   * @return the formElements as a Map. The key represents the elements name, the value is the form elements data.
   */
  Struct getFormElements();

  /**
   * Resolves the admin mails adminMails.
   */
  List<String> getAdminEmails();

  String getFormAction();

  Boolean isSpamProtectionEnabled();

}
