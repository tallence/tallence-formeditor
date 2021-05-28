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

package com.tallence.formeditor.studio.validator.field;

import com.coremedia.cap.struct.Struct;
import com.coremedia.rest.validation.Issues;
import com.tallence.formeditor.cae.FormEditorHelper;
import com.tallence.formeditor.cae.parser.FileUploadParser;
import org.springframework.stereotype.Component;

import static com.tallence.formeditor.cae.parser.AbstractFormElementParser.FORM_DATA_NAME;

/**
 * Validates, that forms where the mail action is selected have no file upload field.
 */
@Component
public class NoFileUploadOnMailActionValidator extends AbstractFormValidator implements FieldValidator {

  @Override
  public boolean responsibleFor(String fieldType, Struct formElementData) {
    return FileUploadParser.parserKey.equals(fieldType);
  }

  @Override
  public void validateField(String id, Struct fieldData, String action, Issues issues) {
    if (FormEditorHelper.MAIL_ACTION.equals(action)) {
      addErrorIssue(issues, id, FORM_DATA_NAME, "form_action_mail_file");
    }
  }
}
